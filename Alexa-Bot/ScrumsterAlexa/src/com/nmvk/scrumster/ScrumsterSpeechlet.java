package com.nmvk.scrumster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.OutputSpeech;

/**
 * Entry point of scrumster application.
 *
 * @author raghav
 */
public class ScrumsterSpeechlet implements SpeechletV2 {
    private static final Logger log = LoggerFactory.getLogger(ScrumsterSpeechlet.class);

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        IntentRequest request = requestEnvelope.getRequest();
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                requestEnvelope.getSession().getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if (ScrumsterIntent.MOVE_WORK_ITEM.equals(intentName)) {
            return handleMoveTask(intent);
        } else if (ScrumsterIntent.SCHEDULE_MEETING.equals(intentName)) {
            return handleMeeting(intent);
        } else if (ScrumsterIntent.HELP_INTENT.equals(intentName)) {
            return getHelpResponse();
        } else if (ScrumsterIntent.SUMMARY.equals(intentName)){
            return handleSummary();
        } else {
            return getAskResponse(Util.title, "This is unsupported.  Please try something else.");
        }
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());
        // any cleanup logic goes here
    }

    /**
     * Creates and returns a {@code SpeechletResponse} with a welcome message.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getWelcomeResponse() {
        String speechText = "Welcome to the Scrumster";
        return getAskResponse(Util.title, speechText);
    }

    /**
     * Handle summary.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse handleSummary() {
        String speechText = "Team has burnt 12 points, team is on track.";

        // Create the Simple card content.
        SimpleCard card = getSimpleCard(Util.title, speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = getPlainTextOutputSpeech(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }

    /**
     * Handle move task.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse handleMoveTask(Intent intent) {

        String taskId = intent.getSlot("taskid") == null ? null :intent.getSlot("taskid").getValue();

        if (taskId == null) {
            return getAskResponse(Util.title, "Sure can you please tell me the task id?");
        }

        String status = intent.getSlot("status") == null ? null : intent.getSlot("status").getValue();

        if (status == null) {
            return getAskResponse(Util.title, "Sure can please tell me the status?");
        }
        String speechText = "Your task " + taskId + " has been successfully moved to " + status ;

        // Create the Simple card content.
        SimpleCard card = getSimpleCard(Util.title, speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = getPlainTextOutputSpeech(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }

    /**
     * Handle meetings.
     *
     * @param intent
     * @return SpeechletResponse
     */
    private SpeechletResponse handleMeeting(Intent intent) {

        String date = intent.getSlot("day") == null ? null :intent.getSlot("day").getValue();

        if (date == null) {
            return getAskResponse(Util.title, "Sure can you tell me when to schedule?");
        }

        String speechText = "Scheduled meeting on " + date + " 2:30PM";

        // Create the Simple card content.
        SimpleCard card = getSimpleCard(Util.title, speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = getPlainTextOutputSpeech(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }

    /**
     * Creates a {@code SpeechletResponse} for the help intent.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getHelpResponse() {
        String speechText = "You can say hello to me!";
        return getAskResponse("HelloWorld", speechText);
    }

    /**
     * Helper method that creates a card object.
     * @param title title of the card
     * @param content body of the card
     * @return SimpleCard the display card to be sent along with the voice response.
     */
    private SimpleCard getSimpleCard(String title, String content) {
        SimpleCard card = new SimpleCard();
        card.setTitle(title);
        card.setContent(content);

        return card;
    }

    /**
     * Helper method for retrieving an OutputSpeech object when given a string of TTS.
     * @param speechText the text that should be spoken out to the user.
     * @return an instance of SpeechOutput.
     */
    private PlainTextOutputSpeech getPlainTextOutputSpeech(String speechText) {
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return speech;
    }

    /**
     * Helper method that returns a reprompt object. This is used in Ask responses where you want
     * the user to be able to respond to your speech.
     * @param outputSpeech The OutputSpeech object that will be said once and repeated if necessary.
     * @return Reprompt instance.
     */
    private Reprompt getReprompt(OutputSpeech outputSpeech) {
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(outputSpeech);

        return reprompt;
    }

    /**
     * Helper method for retrieving an Ask response with a simple card and reprompt included.
     * @param cardTitle Title of the card that you want displayed.
     * @param speechText speech text that will be spoken to the user.
     * @return the resulting card and speech text.
     */
    private SpeechletResponse getAskResponse(String cardTitle, String speechText) {
        SimpleCard card = getSimpleCard(cardTitle, speechText);
        PlainTextOutputSpeech speech = getPlainTextOutputSpeech(speechText);
        Reprompt reprompt = getReprompt(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }
}

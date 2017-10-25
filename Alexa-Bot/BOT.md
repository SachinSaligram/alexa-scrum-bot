## BOT Milestone phase

### Use Case Refinement
#### Refined BOT Description
Scrumster is a bot designed to serve as an advocate of Scrum. The end goal would be to replace one of the existing Scrum roles (scrum master in particular), but at the level of implemetation we are focusing on, we would want the bot to be a catalyst for the overall Scrum process within teams in an organization. Most of us who have experience working in Scrum teams find updating Kanban boards to be a laborious task. Scrumster looks to aid in the process of updating tasks by having a simple voice interaction, through an Alexa application, with engineers during a stand-up to update tasks pertaining to a sprint. At the back end, it is tied to JIRA/Trello APIs to acheive this task. Scrumster aims to provide the following functionality:

* Assist in moving tasks from one state to another (for eg. from 'In-Progess' to 'Done'). 
* Schedule meetings for a duration of 30 minutes or 1 hour when all team members are available. This is achieved by accessing their calendars via the Google Calendar API.
* Summarize the sprint up to that point and provide feedback as to whether the sprint is on track or not.

## Use Cases

1. Use Case - 1
  
  ```
  
Use Case: Move tasks from one state to another as per user input.
1 Preconditions
     User must have access to the Scumster Bot and his/her name must be listed as members of the JIRA Scrum team. The Scrum has to be triggered to be started, user will do this by using a key phrase like "Hey Scrumster". 
2 Main Flow
     After the user starts the Scrumster, the users can give instructions to Scrumster Bot [S1] to move tasks by mentioning the task ID that will be recognized by the Bot[S2]. The user can ask Scrumster to move from any of the valid states. Example - user says "Move task AT-10 to 'Done'/'Completed' column. 
     
3 Subflows
    [S1] User gives Bot instructions to move tasks by calling out task IDs.
    [S2] Bot will move the tasks by recognizing the task ID.
4 Alternative Flows
    [E1] No tasks make transition from one state to the other in the collected updates.
  
  ```
  
2. Use Case - 2

```
Use Case: Sprint Summary and Feedback 
1 Preconditions
   Scrumster Bot should have finished with all the team members' updates. 
2 Main Flow
   At the end of the stand-up meeting, one of the users will use a key-phrase such as "Scrumster, End the meeting" to indicate that the team has finished giving updates and tasks are done moving[S1]. Scrum Bot will analyze the Scrum Board and talk about the progress of the team[S2]. Bot will review performance of the team and comment on current progress v/s previous sprint performance[S3]. 
3 Subflows
  [S1] Bot gets input from user to end the current meeting.
  [S2] Bot will analyze the Scrum board(JIRA/Trello) for tracking the team's overall progress.
  [S3] Talk about overall performance of the team and comparison with past sprint performance.
  
```

3. Use Case - 3

```
Use Case: Schedule a meeting for the team.
1 Preconditions
   All users must have access to Scrum Board.    
2 Main Flow
   One of the users gives speech instruction to Scrumster Bot to schedule a meeting indicating the duration of meeting (we will support only 30mins/1hour meeting slots) [S1]. This will be done for the entire team. Bot checks the calendars of all the team members and schedule a team meeting [S2]. Sends out a notification about the meeting timings [S3]. If no timings match for all the team members, Bot will notify that meeting cannot be scheduled [E1].
3 Subflows
  [S1] User asks Scrumster to schedule a team meeting.
  [S2] Bot checks calendars of all the team members.
  [S3] Bot gives back an update to team mentioning the meeting slot.
 
4 Alternative Flows
  [E1] No timings matching for team members.
```

### Task Tracking

We started using JIRA to track our project in terms of sprints from the first milestone itself. The following image gives a summary of the epic that we completed as part of that milestone (DESIGN).
![m1_jirasummary](https://media.github.ncsu.edu/user/8297/files/311342b4-b98b-11e7-9133-01645740bd83)

### Worksheet
The Worksheet for Milestone 2 (BOT) can be found here: [Worksheet](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Bot/Worksheet.md)

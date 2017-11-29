## Deploy

### Deployment

#### Screencast
Link to screencast for deployment: [deployment screencast]()

Link to screencast for functioning use-cases: [use-cases screencast]()

The Deployment is carried out on a remote AWS environment and automated using Ansible. The Ansible playbook is run using the command:

```
 
 ansible-playbook deployScrumsterAWS.yml --vault-password-file ~/password.txt
 
 ```
 The playbook is composed of the following steps:
 1. Create a new AWS VM
 2. Assign a fixed elastic IP to this VM
 3. Clone the code from our repository
 4. Build the code and produce a jar file
 5. Login to newly created VM and copy jar file to it
 6. Install depedencies to run jar on AWS VM
 7. Run the jar file using nohup
 
We also have a relatively static Amazon lambda function as part of our architecture. This interacts with the AWS VM on which the service is running using calls to the static elastic IP address.
 
 *** In order to establish ssh connectivity with remote AWS instances we require a pem file which we keep on our local host, which cannot be shared.

### Acceptance Testing Instructions

Here, we will describe how to test our use cases for our Scrumster bot and also provide you with sample outputs to get an idea of how it would work.

The basic steps for testing all use cases involve -

1. Login to [echosim.io](https://echosim.io/) using the credentials of Amazon Developer listed below in table (username: scrumuser2017@gmail.com & password: scrumster2017).

2. Make sure the Console button on the echosim page is always ON so that output can be seen as well along with hearing the output. It would be present at the top-right of the page -

![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se1.PNG)

3. Login and keep the JIRA board that we use for testing the use-cases 1&2 always open to see the changes happening. Please use AT board only - [AT board](https://scrumster.atlassian.net/secure/RapidBoard.jspa?rapidView=1&selectedIssue=AT-33) for testing the use cases #1 & #2.

4. Login to google calendars for the users listed below in the table with their credentials to see the output after performing use-case #3.

**Note**- In all our use-cases, bot will be invoked by using 'Ask Scrumster' as initial part of commands.

#### Credential Information

|   |Username|Password|
|---|---|---|
|Amazon Developer|scrumuser2017@gmail.com|scrumster2017|
|Google Calendar|raghav@ouruse.com|WootWoot9060|
|Google Calendar|scrum@ouruse.con|WootWoot9060|
|Google Calendar| kshitija@ouruse.com| WootWoot9060|
|Google Calendar| sachin@ouruse.com| scrumster2017|
|Google Calendar| vishal@ouruse.com| scrumster2017|
|Jira| scrumuser2017@gmail.com| scrumster2017|

#### Important Links

1. Amazon Developer Link : [https://developer.amazon.com/home.html](https://developer.amazon.com/home.html)
2. Echosim.io (URL to test alexa without Alexa, use amazon developer credentials) Link : [https://echosim.io](https://echosim.io)
3. Google Calendar **(Use ouruse credentials listed above)** Link : [https://calendar.google.com/calendar/](https://calendar.google.com/calendar/)
4. Jira Link: [https://scrumster.atlassian.net](https://scrumster.atlassian.net) 

#### Use Case #1 ->

Use Case: Move tasks from one state to another as per user input.
User gives two inputs - 1) Task ID, 2) Status of task, and Scrumster shall move the task accordingly. This has been implemented by using the JIRA REST APIs. 

User shall test by using any of the below given phrases - 
1. "Ask Scrumster to move task {task-ID} to {status}". 

Task-ID can be any valid task-ID present on the Scrum Board - AT board and the task ID is mentioned at the bottom-right of all the tasks listed on the board in active sprint. Our current active sprint is - 'Sample Sprint 2' on AT board.

Task-ID on a task -> example of task-ID here is 30 (if it is AT-16 or AT-30, we always mention on the number of the task to scrumster bot).


![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se2.PNG)



So, valid {status} that can be mentioned in the command can be one of these three - To Do, In Progress, Done.

Example for use-case 1 testing -

Sample utterance at echosim - "Ask Scrumster to move task 16 to Done"

State of AT board current sprint before this action is performed ->
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se3.PNG)

Here AT-16 - Story 2 is in 'To Do' state.

After this sample utterance at echosim, we get the following output on echosim -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se4.PNG)

Refresh the AT board and you will see that Story 2 with task AT-16 has been moved to state Done -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se5.PNG)

2. The second type to test this use-case is that one need not say the entire command at one go. User can split it as -

Initial state of AT board -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se5.PNG)

User utterance - "Ask Scrumster to move task" - to which Scrumster asks -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se6.PNG)

User utterance - "30"  - to which Scrumster shall respond as -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se7.PNG)

User utterance - "In progress" - to which the final response shall be -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se8.PNG)

Now, refresh the board and see its changed state -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se9.PNG)


**Edge Cases** - Edge cases for use-case 1 would be providing invalid Task-ID or status, to which our Bot would respond saying that it is an invalid input. Sample response for invalid status -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se11.PNG)


#### Use Case #2 ->

Use Case: Sprint Summary and Feedback

User sample utterance - "Ask Scrumster to provide summary for the current sprint" / "Ask Scrumster to provide current sprint summary."

This use-case has no edge cases considered and it provides summary of story points only for the current active sprint. As per our current AT board state (as shown last in use-case 1 example) the output would look like -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se10.PNG)

#### Use Case #3 ->

Use Case: Schedule a meeting for the team.

We are using G Suite account - our domain being "ouruse.com" so to get access via Google calendar API. Scrumster schedules a meeting for team by taking the "date" as input. So, for testing our third use-case, follow these steps ->


i) Login to Google Calendar [calendar](https://calendar.google.com/calendar/render) using all of these ouruse.com accounts - raghav@ouruse.com, sachin@ouruse.com, kshitija@ouruse.com, scrum@ouruse.com, vishal@ouruse.com. Password/credentials are provided in the table here - [credentials](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/DEPLOY.md#credential-information). 

ii) Look at the currently blocked slots for all the users' Google Calendars. This is the current calendar for all users (when I was testing) -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se12.PNG)

iii) User utterance at echosim for scheduling meeting - "Ask Scrumster to schedule meeting tomorrow"

iv) Scrumster checks all users' calendars for tomorrow - November 29th and picks up the first free 30-minute slot to book a team meeting. Output would look like ->
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se14.PNG)

And you can see this change reflected on the users' calendars as well. Now, after all the busy slots, a new slot has been booked for team meeting -
![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se15.PNG)

**NOTE** - Important things to be Noted while testing ->
* In our implementation of this meeting scheduling use-case for our project, we have pre-defined slots of 30mins which go from example 9:00 to 9:30am or 9:30 to 10:00am and not 9:05 to 9:35am.
* The available slots would be only within 9am to 5pm (Eastern Time) and no timings excluding this period would be available to book meetings.
* Please log out of personal/other gmail account and use our "ourouse.com" domain only for testing this use-case.

**Edge Case** - 
If a user tries to book a meeting after 5pm or before 9am or when all slots are full, the Scrumster will giev an error.
 Example 1 -> Utterance at echosim.io - "Ask Scrumster to schedule meeting today". Now, since I am trying this after 5pm, it would say not possible -
 ![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se13.PNG)
 
 Example 2 -> I will book a single user's calendar for Wednesday - 11/29 for entire day, and hence Scrumster will be unable to book any meeting for this date and say that team is not free on this date.
 ![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se16.PNG)
 
 Utterance at echosim.io - "Ask Scrumster to schedule meeting tomorrow". Ouput -
 ![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se17.PNG)
 
 **Note** - For best results, testing can be done by using Amazon Echo device (Alexa) by linking it to our Amazon Developer account whose credentials have been given above.

### Exploratory Testing and Code Inspection
We have used JIRA REST APIs for all scrum board related activities and Google Calendar API for scheduling meeting service. We have not hard coded or used mock server. Extensive testing can be perfomed at echosim.io 

### Task Tracking - Worksheet
The Worksheet for Task Tracking for Milestone 4 (DEPLOY) can be found here: [Worksheet](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/WORKSHEET.md)

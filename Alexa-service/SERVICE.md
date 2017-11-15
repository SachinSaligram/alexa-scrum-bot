


In this milestone, we have implemented all the below listed components ->

* Use Case #1 Implementation (20%)
* Use Case #2 Implementation (20%)
* Use Case #3 Implementation (20%)
* Task Tracking -- WORKSHEET.md (20%)
* Screencast (20%)

For deploying our service, we have used Spring framework and the entire code is in Java. We have implemented separate controllers to handle different use cases. To automate the backend service we have used JIRA REST APIs and Google Calendar API.

## Use Case #1 Implementation -

Use Case: Move tasks from one state to another as per user input.

User gives two inputs - 1) Task ID, 2) Status of task, and Scrumster shall move the task accordingly. 
This has been implemented by using the JIRA REST APIs. Service is implemented in our Java service, functions mentioned in controller - [ScrumController.java](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-service/ScrumsterService/src/main/java/com/nmvk/controller/ScrumController.java)

## Use Case #2 Implementation - 

Use Case: Sprint Summary and Feedback

Scrumster shall give the team sprint summary, saying how many points have been burnt. This too has been implemented by using JIRA REST APIs and the service has been included in [ScrumController.java](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-service/ScrumsterService/src/main/java/com/nmvk/controller/ScrumController.java)

## Use Case #3 Implementation

Use Case: Schedule a meeting for the team.

Scrumster schedules a meeting for team by taking the "date" as input. We implemented this using our Java service which uses Google Calendar API to access the team's users' calendars and schedule a meeting accordingly.
The service for this use case has been included in a separate controller - [CalendarController.java](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-service/ScrumsterService/src/main/java/com/nmvk/controller/CalendarController.java)

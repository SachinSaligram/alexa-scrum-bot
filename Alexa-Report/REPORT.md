## Project Report

### Team Members

* Kshitija Mohan Murudi (kmurudi)
* Raghavendra Nayak Muddur (rmuddur)
* Sachin Saligram (ssaligr)
* Vishal Kumar Seshagirirao Anil (vseshag)

### Reports and Demonstration

* [Design](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/DESIGN.md)
* [Bot](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Bot/BOT.md)
* [Service](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-service/SERVICE.md)
* [Deploy](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/DEPLOY.md)
* [Report](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Report/REPORT.md)
* [Project Demo](https://youtu.be/g2zEf1eVQVE)

### Problem Statement

Scrum is a subset of the Agile methodology in software development and it is extensively used today in organizations, big and small. It is known to increase productivity and it modularizes development in cycles of work called Sprints. A Sprint is usually 2-4 weeks long and is conducted using tools such as JIRA or Trello. As a part of scrum, the team conducts daily meetings called "stand-ups" to take updates from team members, and the scrum master conducts and manages these meetings throughout the course of the sprint. There are 3 roles as part of Scrum - Product Owner, Team and Scrum Master. The scrum master acts as the advocate for Scrum, and helps the team learn and apply Scrum to achieve business value.

The bot 'Scrumster' aims to free up manual time and effort that goes into coordinating and managing tasks within a scrum team. Our bot aims to make the scrum process more effective and easier to adopt by,

* automating tasks such as updates on the JIRA board or collecting updates from engineers.
* easing the adoption of scrum by making the transition a less cumbersome task.
* reducing the effort put in by the scrum master as well as the team members.
* making a scrum process more streamlined.

### Bot Description and Features

Scrumster is a bot designed to serve as an advocate of Scrum. The end goal would be to replace one of the existing Scrum roles (scrum master in particular), but at the level of implementation we are focusing on, we would want the bot to be a catalyst for the overall Scrum process within teams in an organization. Most of us who have experience working in Scrum teams find updating Kanban boards to be a laborious task. Scrumster looks to aid in the process of updating tasks by having a simple voice interaction, through an Alexa application, with engineers during a stand-up to update tasks pertaining to a sprint. At the back end, it is tied to JIRA/Trello APIs to achieve this task. Scrumster aims to provide the following primary features:

* Assist in moving tasks from one state to another (for e.g.. from 'In-Progress' to 'Done').
* Schedule meetings for a duration of 30 minutes or 1 hour when all team members are available. This is achieved by accessing their calendars via the Google Calendar API.
* Summarize the sprint up to that point and provide feedback as to whether the sprint is on track or not.

Below are some screenshots and description to help illustrate these use cases.

__1. Use case #1__

* Move tasks from one state to another as per user input. User gives two inputs - 1) Task ID, 2) Status of task, and Scrumster shall move the task accordingly. This has been implemented by using the JIRA REST APIs.

User shall test by using the given phrase - *"Ask Scrumster to move task {task-ID} to {status}"*.

* Task-ID can be any valid task-ID present on the Scrum Board - AT board and the task ID is mentioned at the bottom-right of all the tasks listed on the board in active sprint.
* A valid {status} that can be mentioned in the command can be one of these three - To Do, In Progress, Done.

For example - *"Ask Scrumster to move task 16 to Done"*

__Before Action__

![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se3.PNG)

__After Action__

![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se5.PNG)

__2. Use case #2__

* Sprint Summary and Feedback - This provides summary of story points only for the current active sprint.

__User Utterance__ - *"Ask Scrumster to provide summary for the current sprint" / "Ask Scrumster to provide current sprint summary."*

__Scrumster Response__ - *For the current sprint team has burnt 5 story points out of 20 story points*.

__3. Use case #3__

* Schedule a meeting for the team - We are using a G Suite account, our domain being "ouruse.com", to get access via Google calendar API. 
* Scrumster schedules a meeting for team by taking the "date" as input.
* Scrumster checks all users' calendars and picks up the first free 30-minute slot to book a team meeting.

For example - *"Ask Scrumster to schedule a meeting tomorrow"*

__Before Action__

![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se12.PNG)

__After Action__

![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/se15.PNG)

### Development Process and Project

For developing this application we used Jira, Google Calendar API from G-suite, AWS Lambda function, and AWS EC2 with Java-based spring REST service. Some of the most important points to note in the development process are listed below.

* We chose to develop this application in Java over Node.js since our team had high fluency in Java. 
* In developing the application for voice, we have been concerned with and focussed on latency since voice skills have to execute reliably and quickly. 
* Spring-based REST service was used to perform any long-running task since lambda functions have limited resources. 
* G-suite was used due to the fact it offers an easier and convenient way of integrating the Google Calendar API. 
* We used cloud hosted Jira to reduce the overhead of maintaining different services.

![img](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/images/architecture_diagram.png)

In the deployment phase, we chose to automate the whole process with Ansible. The playbook creates a new EC2 instance, installs dependencies, pushes and builds the code, and runs the service. We faced the challenge of integrating the lambda function, which is relatively static, with a new instantiation of the Java service every time we spun a new virtual machine. In order to solve this issue, we made use of elastic IPs provided by Amazon. In our design, we have the same elastic IP assigned to the virtual machine every time we deploy the application which results in seamless integration with our lambda functions.

### Conclusion and Future Work

In this project we were able to provide a service that we believe can 
* provide value to any team in an organization that follows the Agile methodology
* provide a seamless transition to a Agile environment

The service provides a reliable and consistent execution of tasks with it's implementation based of AWS Lambda, a custom server hosted on AWS EC2 with Java-based spring REST service, and tight integration with JIRA, and Google Calendar APIs from G-suite. However, as a project that we believe has high scope in terms of development and usage, it requires refinement of current features and the addition of new use cases to truly evolve into an indispensable service. Hence, this service can aspire to
* expand integration with agile and calendar services
* create new sprints, tasks, epics, or stories
* uniquely identify a user through voice to provide a more personalized (and secure) experience
* provide more flexibility in terms of adding priority, assignees and notes, to name a few, to tasks. 
* expand calendar functionality to provide more control over event details, room availability based on team size, addition/removal or attendees, and other modifications.

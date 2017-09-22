### DESIGN MILESTONE ###

## Problem Statement

Scrum is a subset of the Agile methodology in software development and it is extensively used today in organizations, big and small. It is known to increase productivity and it modularizes development in cycles of work called Sprints. A Sprint is usually 2-4 weeks long and is conducted using tools such as JIRA or Trello. As a part of scrum, the team conducts daily meetings called "stand-ups" to take updates from team members, and the scrum master conducts and manages these meetings throughout the course of the sprint. There are 3 roles as part of Scrum - Product Owner, Team and ScrumMaster. The ScrumMaster acts as the advocate for Scrum, and helps the team learn and apply Scrum to achieve business value. 

Since a lot of meetings take place in Scrum and there are multiple teams within an organization, a lot of manual time and effort goes into this process. The organization also has to invest in hiring and training a professional ScrumMaster. We believe that this is a problem worth solving and we intend to solve it by developing a Bot named 'Scrumster' that will be perform some of the tasks necessary to co-ordinate and manage a Scrum team. Many of the tasks will be automated such as updating tasks on the JIRA board or collecting updates from Engineers, making the Scrum process much more effective and easier to adopt. Any attempt to ease the adoption of Scrum is something worth pursuing as many organizations find the transition to Scrum a cumbersome task. With this bot, the effort put in by the ScrumMaster as well as the Team members will be significantly reduced and the Scrum process will be much more streamlined.

## Bot Description

Scrumster is a Bot designed to serve as an advocate of Scrum . The end goal would be to replace one of the existing Scrum roles (ScrumMaster in particular), but at the level of implemetation we are focusing on, we would want the bot to be a catalyst for the overall Scrum process within teams in an organization. Most of us who have experience working in Scrum teams find it to be a laborious task, to update Kanban boards and add details to these updates. This is one of the problems Scrumster looks to solve by automating the process of updating tasks by having a simple voice interaction through an Alexa application, with the Engineers during the stand-up to update tasks pertaining to the sprint. At the back end, it is tied to JIRA/Trello APIs to acheive this task.

In addition to collecting information regarding a particular task, it also assists in moving tasks from one state to another (for eg. from 'In-progess' to 'Completed') which further eases the life of an engineer. Lastly, Scrumster also provides the functionality of summarizing the sprint up to that point and providing feedback as to whether the sprint is on track or not. 

## Use Cases

1. Use Case - 1

```
Use Case: Collect updates from team members and update the JIRA board  
1 Preconditions
   User must have access to the Scumster Bot and his/her name listed as member of the JIRA Scrum team. If absent for a particular stand-up, updates have to be supplied prior to meeting in the Application.
2 Main Flow
   User initiates meeting with Bot by introducing him/herself. Bot starts by looking for each member's name on the Team list [S1]. It then checks if the member is present or absent in the scheduled meeting [S2]. If present Scrumster will tell the member the tasks assigned to him/her [S3]. User shall give updates on each listed task [S4]. If the team member is absent or on PTO, the Scrumster Bot shall already have this information collected through the centralized portal [E1].
3 Subflows
  [S1] Bot checks for all members on the team having access to the JIRA board.
  [S2] Bot checks if the member is present or absent.
  [S3] Bot lists down the tasks for the particular member.
  [S4] User has to give his/her updates for the listed tasks by the Bot.
4 Alternative Flows
  [E1] Team member is absent for the meeting.
```

2. Use Case - 2
  
  ```
  
Use Case: Move tasks from one state to another.
1 Preconditions
     User must have access to the Scumster Bot and his/her name must be listed as members of the JIRA Scrum team. 
2 Main Flow
     After updates are collected by the Scrumster Bot, the Bot will check for completed tasks [S1]. The completed tasks are moved from the 'In-progress' column to the `Completed` column on the board [S2]. If no tasks are completed yet, no change is made to the board [E1].
3 Subflows
    [S1] Bot checks for completed tasks after collecting updates from member.
    [S2] Bot will move the completed tasks to 'Done' board.
4 Alternative Flows
    [E1] No tasks make transition from one state to the other in the collected updates.
  
  ```
  
3. Use Case - 3

```
Use Case: Sprint Summary and Feedback 
1 Preconditions
   Scrumster Bot should have finished with all the team members' updates.
2 Main Flow
   At the end of the meeting, Scrum Bot will analyze the Scrum Board and talk about the progress of the team. Bot will review performance of the team and see if target will be met or not. 
3 Subflows
  [S1] Bot checks if all members on the team have finished with their updates or not.
  [S2] Bot will analyze the Scrum board(JIRA/Trello) for number of tasks completed before due date and number of tasks still in progress after due date has expired.
  [S3] Talk about overall performance of the team and how far the team is from the goal.
  
```


## Design Sketches

## Architecture Design

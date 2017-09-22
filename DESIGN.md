### DESIGN MILESTONE ###

## Problem Statement

Scrum is a subset of the Agile methodology in software development and it is extensively used today in organizations, big and small. It is known to increase productivity and it structures development in cycles of work called Sprints. A Sprint is usually 2-4 weeks long and is conducted using tools such as JIRA or Trello. As a part of scrum, the team conducts daily meetings called "stand-ups" to take updates from team members, and the scrum master conducts and manages these meetings throughout the course of the sprint. There are 3 roles as part of Scrum - Product Owner, Team and ScrumMaster. The ScrumMaster acts as the advocate for Scrum, and helps the team learn and apply Scrum to achieve business value. 

Since a lot of meetings take place in Scrum and there are multiple teams within an organization, a lot of manual time and effort goes into this process . The organization also has to invest in hiring and training a professional ScrumMaster. We believe that this is a problem worth solving and we intend to solve it by developing a Bot named 'Scrumster' that will be perform some of the tasks necessary to co-ordinate and manage a Scrum team. Many of the tasks will be automated such as updating tasks on the JIRA board or collecting updates from Engineers, making the Scrum process much more effective and easier to adopt. Any attempt to ease the adoption of Scrum is something worth pursuing as many organizations find the transition to Scrum a cumbersome task. With this bot, the effort put in by the ScrumMaster as well as the Team members will be significantly reduced and the Scrum process will be much more streamlined.

## Bot Description

## Use Cases

1. Use Case - 1

```
Use Case: Ask and collect updates from a team member
1 Preconditions
   User must have access to the Scumster Bot and his/her name listed as members of the JIRA Scrum board. If absent, updates have to be supplied prior to meeting.
2 Main Flow
   User will start meeting with Bot and Bot starts by looking for each member's name on the Team list [S1]. It then checks if the member is present or absent in the scheduled meeting [S2]. If present the Scrumster will request user for updates and note them down [S3]. If the user is absent, Scrumster will bring in the stored updates [E1]. 
3 Subflows
  [S1] Bot checks for all members on the team having access to the JIRA board.
  [S2] Bot checks if the member is present or absent.
  [S3] Bot requests the member for his/her updates and notes them down.
4 Alternative Flows
  [E1] Team member is absent for the meeting.
```

## Design Sketches

## Architecture Design

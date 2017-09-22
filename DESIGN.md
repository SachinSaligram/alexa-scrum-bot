### DESIGN MILESTONE ###

## Problem Statement

Scrum is a subset of Agile methodology in software development and it is the most-widely used one. It is known to increase productivity and it structures development in cycles of work called Sprint. A Sprint is usually of duration 2-4 weeks and is conducted by planning via tools such as JIRA software or Trello. As a part of scrum, everyday the team conducts daily meetings to take updates from the team members and the scrum master is the one who conducts and manages these meetings from the beginning to the end of a sprint. There exist 3 roles in a Scrum - Product Owner, Team, ScrumMaster. The ScrumMaster serves the team and helps the team learn and apply Scrum to achieve business value. 

Since a lot of meetings take place in a Scrum and there are multiple teams in any organization, the time and effort put in by a physically present ScrumMaster is quite a lot. The organization also has to invest effort and money to hire a professional ScrumMaster. We thought of these are our project's main problems to solve and we intend to solve it by developing a Bot named 'Scrumster' that will be doing the tasks necessary to manage a Scrum. Many of the tasks will be automated and the things like moving tasks on the JIRA board or collecting updates from users will be much easier. With this the effort put in by the ScrumMaster as well as the Team members will be significantly reduced.

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

1. Use Case - 2

```
Use Case: Move completed tasks to Done column.
1 Preconditions
   User must have access to the Scumster Bot and his/her name listed as members of the JIRA Scrum board. 
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

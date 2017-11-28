## Deploy

### Deployment

#### Screencast
Link to screencast for deployment: ()

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

3. Login and keep the JIRA board that we use for testing the use-cases 1&2 always open to see the changes happening. Please use AT board - [AT board](https://scrumster.atlassian.net/secure/RapidBoard.jspa?rapidView=1&selectedIssue=AT-33) for testing the use cases #1 & #2.

4. Login to google calendars for the users listed below in the table with their credentials to see the output after performing use-case #3.


#### Use Case #1 ->



- testing use case 1,2,3 using echosim - explain

Ask scrumster to move task - task id - keep console open so that u can debug, - shows respons e(add screencast to show) - sample - one go, split asking to move task.

move task - inavlid task id - tells "sorry, task 1000 not found"

same for sprint summary - direct - "ask scrumster to provide with current sprint summary" - no edge case

login - all google accpunts listed above - see when users are free and try to schedule at that time. - show when no time matches - block 9-5 , - gives no output, tells could not schedule meeting (using only 9-5 EST eastern time -) - team's not free try another date - response, if block date deleted - gives output again. 
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

### Worksheet
The Worksheet for Milestone 4 (DEPLOY) can be found here: [Worksheet](https://github.ncsu.edu/rmuddur/Scrumster/blob/master/Alexa-Deploy/WORKSHEET.md)

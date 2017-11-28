## Deploy

### Deployment

Link to screencast for deployment: 

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
 7. Run the jar file using no hup
 
We also have a relatively static Amazon lambda function as part of our architecture. This interacts with the AWS VM on which the service is running using calls to the static elastic IP address.
 
 *** In order to establish ssh connectivity with remote AWS instances we require a pem file which we keep on our local host, which cannot be shared.

### Acceptance Testing

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

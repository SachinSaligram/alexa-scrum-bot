## Deploy

### Deployment

The Deployment is carried out on a remote AWS environment and automated using Ansible. The Ansible playbook is run using the command

```
 
 ansible-playbook deployScrumsterAWS.yml --vault-password-file ~/password.txt
 
 ```
 
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

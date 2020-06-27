
# Spe-DevOps

By Quentin Nivelais, for the devops option at Supinfo, idbooster : 280797

## Strategy

Create a complete stack on docker with :

- Jenkins (Build, pipeline to transfer artifact, core of the CI/CD process)
- Gitlab (Code hosting, webhook to send each commit to Jenkins)
- SonarQube (Code quality analysis, OWASP analysis for security purpose)
- Nexus (Host builded artifect, and send them to the client)

When this stack is op on docker-compose, run it with kubernetes with the help of the tool 'Kompose'.

If i'have the time, add to the stack :

- Apache httpd server (host builded applications)
- Ansible (Deploy builded app from nexus to the httpd server)

## Jenkins

Unlock password : '788f720a425c4b668e65f2657ebfac3a'

### Admin user

 - User : 280797SpeDevOps
 - Pass : SuperStrongPassword


## Gitlab

 - User : root
 - Pass : SuperStrongPassword
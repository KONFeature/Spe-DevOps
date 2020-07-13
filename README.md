
# Spe-DevOps

By Quentin Nivelais, for the devops option at Supinfo, idbooster : 280797

## Strategy

Create the complete dployment stack on docker with :

- Jenkins (Build, pipeline to transfer artifact, core of the CI/CD process)
- Gitlab (Code hosting, webhook to send each commit to Jenkins)
- SonarQube (Code quality analysis, OWASP analysis for security purpose)
- Nexus (Host builded artifect, and send them to the client)
- Ansible (Server deployment)

Create the complete app stack on docker with :

- NGinx (Server hosting)
- Prometheus (Monitoring)
- Fluentd (Logging collector)

When the two stacks are op with docker-compose, run it with kubernetes with the help of the tool 'Kompose'.

## Deployment part

### Jenkins

 - Unlock password : '788f720a425c4b668e65f2657ebfac3a'

 - User : 280797SpeDevOps
 - Pass : SuperStrongPassword

### Gitlab

 - User : root
 - Pass : SuperStrongPassword

### SonarQube

 - User : admin
 - Pass : admin

 - Declarated sonnar scanner on Jenkins : sonarscanner
 - Declareted sonar server on Jenkins : sonardemo

### Nexus3

 - User : admin
 - Pass : SuperStrongPassword

### GitLab runner

registry command : 

gitlab-runner register \
    --non-interactive \
    --registration-token X2zmThE7tBaZvgFoacEH \
    --locked=false \
    --description docker-stable \
    --url http://gitlab \
    --executor docker \
    --docker-image docker:stable \
    --docker-volumes "/var/run/docker.sock:/var/run/docker.sock" \
    --docker-network-mode gitlab-network

## App part

### Java Server

 - User : root
 - Pass : SuperStrongPassword

## Analysis of the solution

### Criticism

For a production environment, SonarQube will need a separate databse (by default it's using an embeded H2 database). 

Only one user / group was created on each environment, if we want a cleaner solutions we need to create a user for each plateform (On gitlab / sonar / nexus, a user dedicated to Jenkins and to the project groupment)

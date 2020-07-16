
# Spe-DevOps

By Quentin Nivelais, for the devops option at Supinfo, idbooster : 280797

## Strategy

Create the complete deployment stack on docker with :

- Gitlab (Code hosting, pipeline to build, test and transfer artifact)
- SonarQube (Code quality analysis, OWASP analysis for security purpose)
- Nexus (Host builded artifect, and send them to the client)

To use the docker compose file into kubernetes we can use the tool 'Kompose'.

## Deployment servers

### Gitlab

 - User : root
 - Pass : SuperStrongPassword
 - Ci token (for registry) : iaftgrnFh2XuXBWpa11L

### SonarQube

 - User : admin
 - Pass : admin

### Nexus3

 - User : admin
 - Pass : SuperStrongPassword

### GitLab runner

registry command : 

gitlab-runner register \
    --non-interactive \
    --registration-token JC2udrWykxqwxoebN3PE \
    --locked=false \
    --description docker-stable \
    --url https://gitlab \
    --executor docker \
    --docker-image docker:stable \
    --docker-volumes "/var/run/docker.sock:/var/run/docker.sock" \
    --docker-network-mode deployment-network

## Analysis of the solution

### Criticism

For a production environment, SonarQube will need a separate databse (by default it's using an embeded H2 database). 

Only one user / group was created on each environment, if we want a cleaner solutions we need to create a user for each plateform (On gitlab / sonar / nexus, a user dedicated to Jenkins and to the project groupment)

### What have i done

I firstly tried to setup a CI/CD environment using gitlab for code hosting, jenkins for pipeline managment, sonar for testing and nexus for artifact hosting.
I've got a lot of trouble running all this stack of my computer, so i decided to remove the Jenkins part and handle the pipeline on the gitlab server.
To do that, i've juste converted all the pipeline configured in my JenkinsFile to a gitlab-ci config files, and then adapted the pipeline config.
The gitlab pipepile systeme use a gitlab-runner image (that is directly plugged on the docker daemon), and run a docker image for each step of the pipeline, better than running all on the same Jenkins server (even if we can config some jenkins worker, it always run on the same instance for each step of the pipeline)
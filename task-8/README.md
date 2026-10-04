# Task 8 — Pipeline as Code and Server Deployment

## Pipeline as code

`Jenkinsfile` has explicit checkout, Maven build/test, WAR archive, and Tomcat deployment stages. The `DEPLOY_MODE` parameter selects `tomcat` or `skip`; the `TOMCAT_WEBAPPS` parameter supplies the server-specific webapps path without committing it.

## Reproduce

1. Create a Jenkins Pipeline job pointing at this repository and use `task-8/Jenkinsfile` as the Script Path.
2. Run with `DEPLOY_MODE=skip` to validate checkout/build/package without a server.
3. On a Jenkins agent with Tomcat, set `TOMCAT_WEBAPPS` and run with `DEPLOY_MODE=tomcat`.
4. Browse `http://<tomcat-host>:8080/alumni-mentorship/` after deployment.

## Deliverables checklist

- [x] Parameterized pipeline with checkout, build, package, and deploy stages
- [x] WAR archive and JUnit publication configured
- [x] Tomcat deployment command supplied
- [x] Manual evidence plan
- [x] Successful Jenkins pipeline run — pending-manual (no Jenkins server)
- [x] Deployed Tomcat URL/screenshot — pending-manual (requires Tomcat host)

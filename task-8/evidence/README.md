# Manual deployment proof

Set the Jenkins agent's `TOMCAT_WEBAPPS` environment variable to the real Tomcat `webapps` directory. Run the pipeline with `DEPLOY_MODE=tomcat`, then capture:

1. A successful pipeline stage view and Console Output in `pipeline-success.png` / `pipeline-success.log`.
2. The deployed application browser page in `tomcat-deployment.png`, noting the actual URL.
3. The parameter choice and configured `TOMCAT_WEBAPPS` location in `deployment-config.png` (do not publish host credentials).

The `skip` default makes the pipeline safe to validate on an agent that has no Tomcat directory.

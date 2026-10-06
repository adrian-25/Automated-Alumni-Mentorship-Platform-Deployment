# Troubleshooting guide

| Symptom | Likely cause | Resolution |
|---|---|---|
| `java` or `mvn` is not recognized | Java 17/Maven absent from host `PATH` | Install JDK 17 and Maven 3.9+, set `JAVA_HOME`, restart terminal; or use the documented Maven container command |
| Maven cannot resolve dependencies | Network/proxy/cache issue | Verify access to Maven Central, then rerun `mvn -B clean test` |
| Selenium tests are skipped | `RUN_SELENIUM` is not exactly `true` | Set `RUN_SELENIUM=true`, `SELENIUM_REMOTE_URL`, and `APP_BASE_URL` |
| Selenium cannot connect | Chrome container/app is unreachable | Start Selenium with port 4444 and confirm the app health URL is reachable from the test container |
| Tomcat serves 404 | Wrong context path | Use `/alumni-mentorship/`; the WAR name determines this path |
| Container health check fails during startup | Application has not finished initializing | Inspect `docker logs <container>`; the image health check allows a 45-second start period |
| Jenkins deploy fails | Missing Tomcat path/Docker credential/agent Docker access | Configure `TOMCAT_WEBAPPS`, `dockerhub-credentials`, and agent Docker permissions; rerun only after fixing config |
| Ansible cannot connect | Invalid host/user/key or target firewall | Test SSH first, populate environment variables, and do not commit connection secrets |
| Jenkins checkout has no repository or uses an unexpected source | The job was created with the wrong Git URL | Correct the job SCM URL to the repository documented in Task 7, then rerun and retain the original failed build as configuration evidence |
| Ansible reports changes on the second run | Image tag changed or target drift exists | Pin an immutable image tag and inspect changed task output before claiming idempotency |
| Jenkins Git checkout fails for a raw SHA branch specifier | Git plugin fetches branch refs, not an arbitrary commit SHA | Create a new immutable evidence branch that points to the commit and configure `*/branch-name`; retain the failed attempt as evidence |
| `mvn: not found` in Jenkins | The controller/agent image lacks Maven on `PATH` | Configure the Maven 3.9.9 tool (the selected project baseline) or install/use Maven on the agent; verify `mvn -B clean test` before claiming a pipeline result |
| Task 8 deploy path does not exist | The default `TOMCAT_WEBAPPS` points to a nonexistent location on the Jenkins host | Run with `TOMCAT_WEBAPPS=/tomcat_webapps` when using the mounted Tomcat volume |
| Jenkins cannot run `docker` | The Docker CLI is absent or its socket is inaccessible to the Jenkins user | Install the client in the Jenkins container and grant the service user access to the mounted socket; repeat after recreating the container |
| Ansible tries to connect to `${MENTORSHIP_HOST}` | INI inventory files do not expand shell environment syntax | Use the corrected runners, which generate a temporary inventory from explicit host and user arguments, or provide an owned inventory file |

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
| Ansible reports changes on the second run | Image tag changed or target drift exists | Pin an immutable image tag and inspect changed task output before claiming idempotency |

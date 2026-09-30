# Task 7 — Jenkins Installation and Continuous Integration Job

## Supplied CI job

`jenkins/config.xml` is an importable Jenkins Freestyle-job definition. It checks out `main` from GitHub, polls every five minutes, runs `mvn -B clean verify` from `app/`, publishes JUnit XML, and archives the generated WAR. `scripts/verify-build.sh` is the equivalent shell build step.

## Manual installation and reproduction

1. Install Jenkins LTS, Java 17, Git, and Maven on a Jenkins-capable host.
2. In **Manage Jenkins → Tools**, configure JDK 17 and Maven 3.9+ (or ensure they are on `PATH`).
3. Create a Freestyle job named `alumni-mentorship-ci`, then paste/import `jenkins/config.xml` (install the Git plugin if Jenkins requests it).
4. Run **Build Now**, then inspect **Test Result** and **Artifacts**.
5. Configure either the included SCM poll (`H/5 * * * *`) or a GitHub webhook; GitHub webhook setup needs the public Jenkins URL and is therefore manual.

## Deliverables checklist

- [x] Importable Git/Maven Jenkins job configuration
- [x] SCM polling trigger, JUnit publication, and WAR archive configuration
- [x] Equivalent reproducible build script
- [x] Manual capture instructions
- [ ] Jenkins installation/configuration — pending-manual (no Jenkins server installed)
- [ ] Successful build, trigger, and archived-artifact evidence — pending-manual

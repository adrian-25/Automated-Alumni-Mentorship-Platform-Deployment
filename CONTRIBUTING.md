# Contribution and branch policy

Use short-lived branches named `feature/<description>`, `fix/<description>`, `docs/<description>`, or `chore/<description>`. Open a pull request into `develop` for feature work; merge the tested release baseline from `develop` into `main`. Use Conventional Commit-style messages, for example `feat(requests): add mentorship request form`.

Before review, run the relevant Maven checks if Java/Maven are available. PRs must state the linked task, testing performed, and manual evidence still required. Do not commit passwords, tokens, Docker registry credentials, IP addresses, or student/alumni personal data.

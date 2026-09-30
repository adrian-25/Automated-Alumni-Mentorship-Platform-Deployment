#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/../../app"
mvn -B clean verify

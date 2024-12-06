#!/bin/bash

# Navigate to the directory where your Maven project is located
# shellcheck disable=SC2164
cd /documents/Identity E2E Technical Test

# Run Maven clean and verify goals to execute Selenium tests
mvn clean verify

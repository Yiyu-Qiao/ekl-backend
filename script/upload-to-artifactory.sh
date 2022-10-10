#!/usr/bin/bash

set +x

curl -H "Authorization: Bearer ${ARTIFACTORY_TOKEN}" -X PUT "https://qiaohandev.jfrog.io/artifactory/ekl-snapshot-local/de/han/ekl/backend/ekl-backend-0.0.1-SNAPSHOT.jar" -T ./target/ekl-backend-0.0.1-SNAPSHOT.jar

sh 'exit 1'
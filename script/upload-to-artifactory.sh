#!/usr/bin/bash

set +x

curl_return_code=$(curl -H "Authorization: Bearer ${ARTIFACTORY_TOKEN}" -X PUT "https://qiaohandev.jfrog.io/artifactory/ekl-snapshot-local/de/han/ekl/backend/ekl-backend-0.0.1-SNAPSHOT.jar" -T ./target/ekl-backend-0.0.1-SNAPSHOT.jar)

echo 'cur return code : $curl_return_code'
sh 'exit 1'
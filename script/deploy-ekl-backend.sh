#!/usr/bin/bash

echo $idjenkinsuser
cat $idjenkinsuser
scp -i $idjenkinsuser ./target/ekl-backend-0.0.1-SNAPSHOT.jar jenkins-user@192.168.178.62:/home/jenkins-user/tmp/ekl-backend/

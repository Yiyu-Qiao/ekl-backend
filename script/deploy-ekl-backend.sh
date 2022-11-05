#!/usr/bin/bash

echo $idjenkinsuser
cp $idjenkinsuser ./pk-jenkins-user.txt
chmod u=rw,go-rwx ./pk-jenkins-user.txt
cat $idjenkinsuser
cat pk-jenkins-user.txt
scp -i pk-jenkins-user.txt ./target/ekl-backend-0.0.1-SNAPSHOT.jar jenkins-user@192.168.178.62:/home/jenkins-user/tmp/ekl-backend/

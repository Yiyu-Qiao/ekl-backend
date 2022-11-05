#!/usr/bin/bash

echo $idjenkinsuser
cp $idjenkinsuser ./pk-jenkins-user.txt
chmod u=rw,go-rwx ./pk-jenkins-user.txt
cat $idjenkinsuser
return_code_scp=$(scp -i ./pk-jenkins-user.txt ./target/ekl-backend-0.0.1-SNAPSHOT.jar jenkins-user@192.168.178.62:/home/jenkins-user/tmp/ekl-backend/)
echo $return_code_scp

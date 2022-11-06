#!/usr/bin/bash
java -jar /home/jenkins-user/tmp/ekl-backend/ekl-backend-0.0.1-SNAPSHOT.jar & echo $! > ./ekl_backend_pid.txt &

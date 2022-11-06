#!/usr/bin/bash
java -jar ./tmp/ekl-backend/ekl-backend-0.0.1-SNAPSHOT.jar & echo $! > ./tmp/ekl-backend/ekl_backend_pid.txt &

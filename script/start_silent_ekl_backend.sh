#!/usr/bin/bash
nohup ./tmp/ekl-backend/script/start_ekl_backend.sh >> ./tmp/ekl-backend/log/ekl_backend.log 2>&1 < /dev/null &

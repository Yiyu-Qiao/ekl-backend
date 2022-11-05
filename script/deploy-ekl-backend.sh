#!/usr/bin/bash

echo $idjenkinsuser
ssh -i $idjenkinsuser jenkins-user@192.168.178.62
id
hostname

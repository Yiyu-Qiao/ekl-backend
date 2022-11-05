pipeline {
    agent any
    tools {
        maven 'apache-maven-3.8.6'
    }
    stages {
        stage('Init Git') {
            steps {
                script{
                    def msg = sh(returnStdout:true, script:'''echo check out from Github Repository ${GIT_URL}
                                                              echo current branch ${GIT_BRANCH}''')
                    echo 'Console output:' + msg
                }
            }
        }

        stage('Maven build'){
            steps {
                configFileProvider([configFile(fileId: 'global-maven-settings', variable: 'MAVEN_SETTINGS')]){
                    sh 'mvn -s $MAVEN_SETTINGS clean install'
                }
            }
        }

        stage('Deploy to Artifactory'){
            steps {
                withCredentials([string(credentialsId: 'Artifactory-Access-Token-QiaoHanDev', variable: 'ARTIFACTORY_TOKEN')]){
                    sh """
                        #!/usr/bin/bash
                        source ./script/upload-to-artifactory.sh
                    """
                }
            }
        }

        stage('Deploy ekl-backend'){
            steps {
                withCredentials([file(credentialsId:'pk-jenkins-user',variable: 'idjenkinsuser')]){
                    sh """
                        ssh -i $idjenkinsuser jenkins-user@192.168.178.62
                        pwd
                        id
                        hostname
                        #!/usr/bin/bash
                        source ./script/deploy-ekl-backend.sh
                    """
                }
            }
        }
    }
}

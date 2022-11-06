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
                withCredentials([string(credentialsId: 'Artifactory_Access_Token_QiaoHanDev', variable: 'ARTIFACTORY_TOKEN')]){
                    sh """
                        #!/usr/bin/bash
                        source ./script/upload-to-artifactory.sh
                    """
                }
            }
        }
        stage('Deploy ekl-backend'){
            steps {
                withCredentials([usernamePassword(credentialsId:'SSH_Jenkins_User', usernameVariable: 'username', passwordVariable: 'password')]){
                    script {
                        def remote_ekl_backend = [:]
                        remote_ekl_backend.name = 'Intel-NUC-1'
                        remote_ekl_backend.host = '192.168.178.62'
                        remote_ekl_backend.allowAnyHosts = true
                        remote_ekl_backend.user = username
                        remote_ekl_backend.password = password
                        sshCommand remote: remote_ekl_backend, command: 'id'
                        sshCommand remote: remote_ekl_backend, command: 'hostname'
                        sshCommand remote: remote_ekl_backend, command: 'ls -la'
                        //sshRemove remote: remote_ekl_backend, path: '/home/jenkins-user/tmp/ekl-backend/ekl-backend-0.0.1-SNAPSHOT.jar'
                        sshPut remote: remote_ekl_backend, from: 'ekl-backend-0.0.1-SNAPSHOT.jar', into: '/home/jenkins-user/tmp/ekl-backend/'
                    }
                }
            }
        }
    }
}

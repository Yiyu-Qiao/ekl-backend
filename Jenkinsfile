pipeline {
    agent any
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
                /** sh 'mvn clean install' **/
                sh """
                   #!/usr/bin/bash
                   source ./script/mvn-clean-install.sh
                """
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
    }
}

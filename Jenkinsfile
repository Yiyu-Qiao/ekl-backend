pipeline {
    agent any
    stages {
        stage('Init Git') {
            steps {
                script{
                    def msg = sh(returnStdout:true, script:'''echo check out from Github Repository ${GIT_URL}
                                                              echo current branch ${GIT_BRANCH}''')
                    echo msg
                }
            }
        }

        stage('Maven build'){
            steps {
                sh 'mvn clean install'
            }
        }
    }
}

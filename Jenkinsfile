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
                sh 'mvn clean install'
            }
        }

        stage('Deploy to Artifactory'){
            steps {
                withCredentials([string(credentialsId: 'Artifactory-Access-Token-QiaoHanDev', variable: 'ARTIFACTORY_TOKEN')]){
                    sh """
                        set +x
                        curl -H "Authorization: Bearer ${ARTIFACTORY_TOKEN}" -X PUT "https://qiaohandev.jfrog.io/artifactory/ekl-snapshot-local/de/han/ekl/backend/ekl-backend-0.0.1-SNAPSHOT.jar" -T ./target/ekl-backend-0.0.1-SNAPSHOT.jar
                    """
                    sh 'exit 1'
                }
            }
        }
    }
}

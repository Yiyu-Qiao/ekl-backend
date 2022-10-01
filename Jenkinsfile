pipeline {
    agent any
    stages {
        stage('Init Git') {
            steps {
                sh '''echo check out from Github Repository ${GIT_URL}
                      echo current branch ${GIT_BRANCH}'''
            }
        }

        stage('Maven build'){
            steps {
                sh 'mvn clean install'
            }
        }
    }
}

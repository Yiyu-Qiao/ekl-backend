pipeline {
    agent any
    stages {
        stage('checkout Git') {
            steps {
                sh 'echo check out from Github Repository ${GIT_URL}'
                sh 'echo current branch ${GIT_BRANCH}'
                sh 'git fetch origin ${GIT_BRANCH}'
                sh 'git checkout -b ${GIT_BRANCH} origin/${GIT_BRANCH}'
            }
        }

        stage('reset build environment'){
            sh 'git branch -D dev'
        }
    }
}

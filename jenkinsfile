stages {
  stage('checkout Git') {
    steps {
        checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'Credential_GitHub_QH', url: 'https://github.com/QiaoHanDev/ekl-backend.git']]]
    }
  }

}

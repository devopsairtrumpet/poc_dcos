pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew clean build'
      }
    }

    stage('DockerPublish'){
        steps{
            docker.build("aayushjain/playground:${env.GIT_COMMIT}").push()
        }

    }
  }
}
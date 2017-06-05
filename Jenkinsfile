pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew clean build'
      }
    }

    stage('DockerPublish'){
      // Build and push image with Jenkins' docker-plugin
           withDockerRegistry([credentialsId: '1b897fc4-3a7c-419d-b0c8-9695c9d96590']) {
             def image = docker.build("aayushjain/playground:${env.GIT_COMMIT}")
             image.push()
           }
    }
  }
}
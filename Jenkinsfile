pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew clean build'
      }
    }

  stage('Build image') {
          /* This builds the actual image; synonymous to
           * docker build on the command line */

          app = docker.build("aayushjain/playground")
      }

      stage('Push image') {
          /* Finally, we'll push the image with two tags:
           * First, the incremental build number from Jenkins
           * Second, the 'latest' tag.
           * Pushing multiple tags is cheap, as all the layers are reused. */
          docker.withRegistry('https://registry.hub.docker.com', '1b897fc4-3a7c-419d-b0c8-9695c9d96590') {
              app.push("${env.GIT_COMMIT}")
              app.push("latest")
          }
      }



  }
}
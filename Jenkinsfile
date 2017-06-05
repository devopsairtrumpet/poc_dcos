pipeline {

  agent any
  stages {

    stage('Build') {
      steps {
        sh './gradlew clean build'
        // change the docker credential when moving to a new Jenkins instance
        script {
        docker.withRegistry('https://registry.hub.docker.com', '1b897fc4-3a7c-419d-b0c8-9695c9d96590') {
                      def app = docker.build("aayushjain/playground")
                      sh 'git rev-parse HEAD > commit'
                      def commit = readFile('commit').trim()
                      app.push("${commit}")
                      app.push("latest")

                      def marathonFile = new File("marathon.json")
                      marathonFile.replaceAll('version_tag' , '${commit}')
                  }

        }
      }
    }

    stage('Marathon Deploy'){
        steps{
            script{
              sh 'cat marathon.json'
            }
            marathon appid: '', credentialsId: '', docker: '', forceUpdate: true, url: 'http://marathon.mesos:8080'
        }

    }
  }
}
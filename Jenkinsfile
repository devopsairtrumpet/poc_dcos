pipeline {

  agent any
  stages {

    stage('Build') {
      steps {
        sh './gradlew clean build'
        script {
        docker.withRegistry('https://registry.hub.docker.com', '1b897fc4-3a7c-419d-b0c8-9695c9d96590') {
                      def app = docker.build("aayushjain/playground")
                      sh 'git rev-parse HEAD > commit'
                      def commit = readFile('commit').trim()
                      app.push("${commit}")
                      app.push("latest")
                      echo "Updating marathon json file with Git commit ${commit}"
                      sh 'sed -i -e "s/version_tag/${commit}/g" marathon.json'
                      echo "Updated file here"
                      sh 'cat marathon.json'
                  }

        }
      }
    }


    stage('Marathon Deploy'){
        steps{
            marathon appid: '', credentialsId: '', docker: '', forceUpdate: true, url: 'http://marathon.mesos:8080'
        }

    }
  }
}
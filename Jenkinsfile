pipeline {

  agent any
  stages {

    stage('Checkout'){
        steps{
            git credentialsId: '8808e5bd-e162-412e-8082-f5fb12b8a6a3', url: 'https://github.com/ursaayush/poc_dcos.git'
        }

    }

    stage('Build') {
      steps {
        sh './gradlew clean build'
        }
    }

    stage('Docker Build and Push'){
        steps{
             // change the docker credential when moving to a new Jenkins instance
                    script {
                    docker.withRegistry('https://registry.hub.docker.com', '1b897fc4-3a7c-419d-b0c8-9695c9d96590') {
                                  def app = docker.build("aayushjain/playground")
                                  sh 'git rev-parse HEAD > commit'
                                  def commit = readFile('commit').trim()
                                  app.push("${commit}")
                                  app.push("latest")

                              }
                    }
                  }
    }

    stage('Marathon Deploy'){
        steps{
            script{
                sh 'git rev-parse HEAD > commit'
                def textOfFile = readFile("marathon.json").replaceAll('version_tag' , readFile('commit').trim()).trim()
                def file = "marathon.json"
                writeFile(file:"marathon.json" , text:"${textOfFile}")
                sh 'cat marathon.json'
            }
            marathon appid: '', credentialsId: '', docker: '', forceUpdate: true, url: 'http://marathon.mesos:8080'
        }

    }
  }
}
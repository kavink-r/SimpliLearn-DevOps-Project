pipeline {
	agent any
	tools {
    maven 'maven' 
  }
	stages {
		stage("Building the project"){
			steps{
				bat 'mvn clean package'
			}
		}
		stage("Creating docker image"){
			steps{
				bat 'docker build -t kavinkr/devops-project:api .'
			}
		}
		stage("Pushing docker image to DockerHub"){
			steps{
				bat 'docker push kavinkr/devops-project:api'
			}
		}

		stage("Pulling image from docker hub and executing container on api server over SSH connection"){
			steps{
				sshPublisher(publishers: [sshPublisherDesc(configName: 'api-host', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sudo docker pull kavinkr/devops-project:api', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: ''), sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sudo docker run -d -p 8090:8080 --env-file appenv.txt --name api kavinkr/devops-project:api', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
			}
		}
		
	}
}             
pipeline {
	agent any
	tools {
    maven 'maven' 
  }
	stages {
		stage("Building the project"){
			steps{
				echo "Building the project using Maven"
				bat 'mvn clean package'
			}
		}
		stage("Containerizing using docker"){
			steps{
				echo "Containerizing the application using Docker"
				bat 'docker build -t kavinkr/sample-app:JpipeAPI .'
			}
		}
		stage("Pushing to Dockerhub"){
			steps{
				echo "Pushing the docker image to dockerhub"
				bat 'docker push kavinkr/sample-app:JpipeAPI'
			}
		}
		stage("Executing the docker image in AWS cloud instance"){
			steps{
				echo "establishing SSH connection to AWS cloud instance"
				echo "Pulling the docker image and executing the docker container"
				sshPublisher(publishers: [sshPublisherDesc(configName: 'awsec2-kav', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sudo docker container rm -f JpipeAPI', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: ''), sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sudo docker pull kavinkr/sample-app:JpipeAPI', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: ''), sshTransfer(cleanRemote: false, excludes: '', execCommand: 'sudo docker run -d -p 8090:8080 --name JpipeAPI --env-file appenv.txt kavinkr/sample-app:JpipeAPI', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
			}
		}
	}
}             
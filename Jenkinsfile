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
			}
		}
		stage("Pushing to Dockerhub"){
			steps{
				echo "Pushing the docker image to dockerhub"
			}
		}
		stage("Executing the docker image in AWS cloud instance"){
			steps{
				echo "establishing SSH connection to AWS cloud instance"
				echo "Pulling the docker image and executing the docker container"
			}
		}
	}
}             
pipeline {
	agent any
	stages {
		stage("Building the project"){
			steps{
				echo "Building the project using Maven"
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
		stage("Executing the docker image is AWS cloud instance"){
			steps{
				echo "establishing SSH connection to AWS cloud instance"
				echo "Pulling the docker image and executing the docker container"
			}
		}
	}
}             
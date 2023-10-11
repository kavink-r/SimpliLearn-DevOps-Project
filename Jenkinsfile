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
				bat 'docker build -t SimpliLearn-Devops-Project:api .'
			}
		}
		stage("Creating and executing docker container"){
			steps{
				bat 'docker run -d -p 8090:8080 --env-file /home/ubuntu/appenv.txt --name RestApi SimpliLearn-Devops-Project:api'
			}
		}
		
	}
}             
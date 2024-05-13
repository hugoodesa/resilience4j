/*pipeline {

   agent any
    tools {
      maven 'maven_local'
      jdk 'java_local'
    }
    stages{
        
        stage("build"){
            steps{
                echo 'builing the application'
                sh 'cd consultDollarPrice'
                sh 'mvn clean install -DskipTests'
            }
        }    

        stage("test") {
            steps{
                sh 'cd /consultDollarPrice'
                echo 'mvn test'
            }
        } 
        
        stage("deploy") {
            steps{
                echo 'deploying the application'
            }
        }
    }

}*/

pipeline {
    
    agent {
        docker {
            image 'maven:3.9.3-eclipse-temurin-17'
        }
    }

    stages {

        stage('Initialize'){
            def dockerHome = tool 'myDocker'
            env.PATH = "${dockerHome}/bin:${env.PATH}"
        }

        stage('build') {
            steps {
                echo 'test'
            }
        }
    }
}
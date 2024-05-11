pipeline {

    //maven , groovy , gradle , npm etc..
    agent { docker { image 'maven:3.9.6-eclipse-temurin-17-alpine' } }

    stages{
        
        stage("build"){
            steps{
                echo 'builing the application'
                sh 'mvn clean install -DskipTests'
            }
        }    

        stage("test") {
            steps{
                echo 'mvn test'
            }
        }
        
        stage("deploy") {
            steps{
                echo 'deploying the application'
            }
        }
    }

}
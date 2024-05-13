pipeline {

   agent any
    /* tools {
      maven 'maven_local'
      jdk 'java_local'
    } */
    stages{

        stage("build"){
            steps{
                echo 'builing the application'
            }
        }

        stage("deploy") {
            steps{
                echo 'deploying the application'
            }
        }

        stage('mavenStage') {
            steps {
                dir('consultDollarPrice') {
                    // Assuming Maven is installed on Jenkins agent
                    sh 'mvn clean install'
                }
            }
        }

    }

}
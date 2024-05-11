pipeline {

   agent any
    tools {
      maven 'MAVEN_LOCAL'
      jdk 'JAVA_LOCAL'
    }
    stages{
        
        stage("build"){
            steps{
                echo 'builing the application'
                sh 'cd /consultDollarPrice'
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

}
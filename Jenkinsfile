pipeline {

    agent any //maven , groovy , gradle , node etc..

    stages{
        
        stage("build"){
            steps{
                echo 'builing the application'
            }
        }    

        stage("test") {
            steps{
                echo 'testing the application'
            }
        }
        
        stage("deploy") {
            steps{
                echo 'deploying the application'
            }
        }
    }

}
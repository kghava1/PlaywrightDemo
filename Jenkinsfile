pipeline
{
    agent any

    tools{
        maven 'maven'
    }
    stages {
            stage('Checkout Code') {
                steps {
                    git branch: 'main', url: 'https://github.com/kghava1/PlaywrightDemo.git'
                }
            }
            stage("Run Tests") {
                steps {
                    sh 'mvn clean test'
                }
            }
    }
}
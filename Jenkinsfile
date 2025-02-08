pipeline {
    agent any

    tools {
        maven 'maven'  // Ensure Maven is installed in Jenkins
    }

    stages {
        stage('Cleanup Workspace') {
            steps {
                deleteDir()  // Clean workspace before every build
            }
        }

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/kghava1/PlaywrightDemo.git'  // Checkout code from GitHub
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'  // Run Maven tests
            }
        }

        stage('Archive Test Results') {
            steps {
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', fingerprint: true  // Archive test results
            }
        }
    }
}

pipeline
{
    agent any

    tools{
        maven 'maven'
    }
    stages{
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
        stage("Regression Automation Test"){
            steps{
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
                    git branch: 'master', credentialsId: '50f386a6-315a-4ce1-be42-3e23b9c600a4', url: 'https://github.com/kghava1/PlaywrightDemo.git'
                    sh 'mvn clean test'
                }
            }
        }
        stage("Publish Extent Report"){
            steps{
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: false,
                             keepAll: true,
                             reportDir: 'build',
                             reportFiles: 'TestExecutionReport.html',
                             reportName: 'HTML Extent Report',
                             reportTitles: ''])
            }
        }
    }
}
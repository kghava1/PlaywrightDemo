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
                    git 'https://github.com/kghava1/PlaywrightDemo'
                    sh 'mvn clean test -Dsurefire.suitXmlFiles=src/test/resources/testRunner/testng_regression.xml'
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
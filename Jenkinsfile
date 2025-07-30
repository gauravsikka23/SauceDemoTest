pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'       // Name of Maven tool configured in Jenkins
        jdk 'JDK-21'
           // Name of JDK configured in Jenkins
    }

    environment {
        SUITE_FILE = "testng.xml"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'CaseStudy_Intermediate',
                    url: 'https://github.com/your-username/SauceDemoTest.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=${SUITE_FILE}'
            }
        }

        stage('Archive Test Results') {
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'screenshots/*.png', fingerprint: true
                }
            }
        }
    }
}

pipeline {
    agent any

    tools {
        maven 'Maven'         // Use the exact tool name from Jenkins
        jdk 'jdk-21'          // Match Jenkins-installed tool name
    }

    environment {
        SUITE_FILE = "testng.xml"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'CaseStudy_Intermediate',
                    url: 'https://github.com/gauravsikka23/SauceDemoTest.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=${SUITE_FILE}'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'screenshots/*.png', fingerprint: true
        }
    }
}

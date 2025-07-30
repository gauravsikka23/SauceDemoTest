pipeline {
    agent any

    tools {
        maven 'Maven'       // Must match your Jenkins configuration
        jdk 'jdk-21'         // Must match your Jenkins configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'CaseStudy_Intermediate', url: 'https://github.com/gauravsikka23/SauceDemoTest.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}

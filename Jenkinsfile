pipeline {
    agent any

    tools {
        maven 'Maven_Home'  // This must match your Jenkins Maven installation name
        jdk 'JDK17'         // Replace with the name of your configured JDK
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

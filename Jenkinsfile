pipeline {
    agent any

    tools {
        jdk 'jdk-21'           // Must match the name of JDK 21 in Jenkins tool config
        maven 'maven-3.4.4'    // Must match Maven tool name in Jenkins tool config
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'  // publish test results
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying application..."
                // Add your deployment logic here (e.g., scp, docker build, etc.)
            }
        }
    }

    post {
        always {
            echo "Pipeline completed."
        }
        failure {
            echo "Build failed!"
        }
        success {
            echo "Build succeeded!"
        }
    }
}

pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-21'
            args '-w /var/jenkins_home/workspace/shelter-new'
        }
    }

    environment {
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Code Format Check') {
            steps {
                echo '🔍 Checking Java code format with Spotless...'
                sh 'mvn spotless:check'
            }
            post {
                failure {
                    echo '❌ Spotless check failed. Please run "mvn spotless:apply" locally to fix formatting.'
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
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
    }

    post {
        always {
            echo '🧹 Cleaning workspace...'
            cleanWs()
        }
        success {
            echo '✅ Build completed successfully with Spotless formatting check passed!'
        }
        failure {
            echo '❌ Build failed — check Spotless or test results.'
        }
    }
}

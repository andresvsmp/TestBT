pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "rmdir  /s /q SeleniumTestAV"
                bat "git clone https://github.com/andresvsmp/SeleniumTestAV.git"
                bat "mvn clean -f SeleniumTestAV"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f SeleniumTestAV"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f SeleniumTestAV"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f SeleniumTestAV"
            }
        }
    }
}

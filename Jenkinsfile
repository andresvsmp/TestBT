pipeline{
    agent {label 'master'}

        stages{

            stage ('test') {
            steps{
                dir("build_java"){
                     sh "mvn clean compile test"
                }

            }
            }
        }

}
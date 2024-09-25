pipeline{
    environment{
        // DOCKERHUB_CRED = credentials("Dockerhub-Credentials-ID")
        DOCKER_IMAGE_NAME = 'calculator'
        GITHUB_REPO_URL = 'https://github.com/siddharth-kothari9403/Calculator_SPE.git'
    }
    agent any
    stages{

        stage("Stage 1 : Git Clone"){
            steps{
                script{
                    git branch : 'main', url : "${GITHUB_REPO_URL}"
                }
            }
        }
        
        stage("Stage 2 : Maven Build"){
            steps{
                sh 'mvn clean install'
            }
        }
        
        stage("Stage 3 : Build Docker Image"){
            steps{
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }
        
        stage("Stage 4 : Push Docker Image to Dockerhub"){
            steps{
                script{
                        docker.withRegistry('', 'Dockerhub-Credentials-ID') {
                        sh 'docker tag calculator siddharthkothari9403/calculator:latest'
                        sh 'docker push siddharthkothari9403/calculator'
                    }
                }
            }
        }
        
        // stage("Stage 5 : Clean Unwanted Docker Images"){
        //     steps{
        //         sh "docker container prune -f"
        //         sh "docker image prune -a -f"
        //     }
        // }
        
        stage('Stage 6 : Ansible Deployment') {
            steps {
                // ansiblePlaybook colorized: true,
                // credentialsId: 'localhost',
                // installation: 'Ansible',
                // inventory: 'inventory',
                // playbook: 'Deploy-Calculator.yml'
                script{
                    ansiblePlaybook(
                        playbook: 'Deploy-Calculator.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
}
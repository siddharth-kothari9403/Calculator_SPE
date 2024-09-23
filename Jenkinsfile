pipeline{
    environment{
        DOCKERHUB_CRED = credentials("Dockerhub-Credentials-ID")
    }
    agent any
    stages{
        // stage("Stage 1 : Git Clone"){
        //     steps{
        //         git "https://github.com/siddharth-kothari9403/Calculator_SPE.git"
        //     }
        // }
        
        stage("Stage 1 : Maven Build"){
            steps{
                sh 'mvn clean install'
            }
        }
        
        stage("Stage 2 : Build Docker Image"){
            steps{
                sh "docker build -t siddharthkothari9403/calculator:latest ."
            }
        }
        
        stage("Stage 3 : Push Docker Image to Dockerhub"){
            steps{
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh "docker push siddharthkothari9403/calculator:latest"
            }
        }
        
        stage("Stage 4 : Clean Unwanted Docker Images"){
            steps{
                sh "docker container prune -f"
                sh "docker image prune -a -f"
            }
        }
        
        stage('Stage 5 : Ansible Deployment') {
            steps {
                sh 'set -e; ansible-playbook -i inventory Deploy-Calculator.yml'
            }
        }
    }
}
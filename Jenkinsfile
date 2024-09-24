pipeline{
    environment{
        DOCKERHUB_CRED = credentials("Dockerhub-Credentials-ID")
    }
    agent any
    stages{
        
        stage("Stage 2 : Maven Build"){
            steps{
                sh 'mvn clean install'
            }
        }
        
        stage("Stage 3 : Build Docker Image"){
            steps{
                sh "docker build -t siddharthkothari9403/calculator:latest ."
            }
        }
        
        stage("Stage 4 : Push Docker Image to Dockerhub"){
            steps{
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh "docker push siddharthkothari9403/calculator:latest"
            }
        }
        
        stage("Stage 5 : Clean Unwanted Docker Images"){
            steps{
                sh "docker container prune -f"
                sh "docker image prune -a -f"
            }
        }

        stage("Stage 6 : Pull Image from Dockerhub"){
            steps{
                sh 'echo $DOCKERHUB_CRED_PSW | docker login -u $DOCKERHUB_CRED_USR --password-stdin'
                sh 'docker pull siddharthkothari9403/calculator:latest'
            }
        }

        stage("Stage 7 : Create Container"){
            steps{
                sh 'docker create -it --name Calculator siddharthkothari9403/calculator'
            }
        }
        
        // stage('Stage 6 : Ansible Deployment') {
        //     steps {
        //         sh 'ansible-playbook -i inventory Deploy-Calculator.yml'
        //     }
        // }
    }
}
def call(String credId, String imageName){
  withCredentials([usernamePassword(
                    credentialsId: "${credId}",
                    passwordVariable: "dockerHubpass",
                    usernameVariable: "dockerHubUser"
                    )]){
                        
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubpass}"
                sh "docker tag django-notes-app ${env.dockerHubUser}/${imageName}"
                sh "docker push ${env.dockerHubUser}/${imageName}"
                       
                    }
}

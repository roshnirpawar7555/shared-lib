def call(body) 
{	
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
pipeline
{
 agent any
   stages
  {
   stage('with')
   {
    steps
      {
       script
        {
withCredentials([usernamePassword(credentialsId: 'my_password', passwordVariable: 'pass', usernameVariable: 'user')]) {
    sh """
sed -i 's/#token-password/$pass/g' token
cat token
"""
}
        }
      }
   }
  }
}
}

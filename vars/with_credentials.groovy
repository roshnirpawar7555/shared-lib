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
   stage('replace')
   {
    steps
      {
       script
        {
sh """
withCredentials(([usernamePassword(credentialsId: 'my_password', passwordVariable: 'pass', usernameVariable: 'user')])) {
    // some block
}
"""
        }
      }
   }
  }
}
}

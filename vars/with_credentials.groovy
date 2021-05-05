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
withCredentials([string(credentialsId: 'my_secret', variable: 'Secret')]) {
    sh """
sed -i 's/#token-password/$Secret/g' token
cat token
"""
}
            sh """
            cat token
            """
        }
      }
   }
  }
}
}

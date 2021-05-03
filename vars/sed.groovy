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
sed -i 's/roshni/ruhi/g' token
cat token
"""
        }
      }
   }
  }
}
}

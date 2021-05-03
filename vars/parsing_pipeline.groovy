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
   stage('Build')
    def json = libraryResource "${config.token_file}"
        def inputjson = new JsonSlurperClassic().parseText(json)
        def serviceAccount = inputjson.account;
  }

}
	
}	

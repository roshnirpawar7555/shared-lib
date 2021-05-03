import groovy.json.JsonSlurperClassic
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
   {
    steps
      {
       script
        {
		def json = libraryResource "config_${envname}.json"
        def inputjson = new JsonSlurperClassic().parseText(json)
        def fruit = inputjson.fruit;
	  //print fruit
		
	sh '''
	echo $fruit
	'''
	}
      }
    }
  }

}
	
}	

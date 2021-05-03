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
sed 's/roshni/ruhi/' token
cat token
"""
        }
      }
   }
  }
}

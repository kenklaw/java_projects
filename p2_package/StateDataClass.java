package p2_package;


public class StateDataClass implements Comparable<StateDataClass>
{
      // member data
      private String state;
      private String captial;
      private long population;

      /** Initialization constructor, initializes state data to default values
       * 
       * @param inStateName String value with state name
       *
       * @param inStateAbbrev integer population for state
       *
       * @param inStatePopulation integer population for state
       */
      public StateDataClass( String inStateName, String inStateAbbrev, long inStatePopulation )
      {
         state = inStateName;
         captial = inStateAbbrev;
         population = inStatePopulation;
      }

      /** Copy constructor, sets all data to copied object
       * 
       * @param copiedSDC StateDataClass object to be copied
       */
      public StateDataClass( StateDataClass copiedSDC )
      {
         state = copiedSDC.state;
         captial = copiedSDC.captial;
         population = copiedSDC.population;
      }

      /** Provides required method for comparing this object 
       * to another StateDataClass object
       *  
       * @param other object of StateDataClass with which to compare
       */
      public int compareTo( StateDataClass other )
      {
         int difference, index = 0;       
         char thisStateChar, otherStateChar;

         while( index < this.state.length() && index < other.state.length() )
         {
            thisStateChar = this.state.charAt( index );
            otherStateChar = other.state.charAt( index );

            difference = toLowerCase( thisStateChar ) - toLowerCase( otherStateChar );

            if( difference != 0 )
            {
               return difference;
            }

            index++;  
         }

         return this.state.length() - other.state.length();
      }

      /** 
       * Changes character to lower case only if character was originally 
       * an upper case letter
       * 
       * @param testChar Character to be tested, if it is upper case it will 
       * be converted to lower case;
       * 
       * @return returns the lower case version of a letter 
       * if it was an upper case letter;
       */
      public char toLowerCase( char testChar )
      {
         if( testChar >= 'A' && testChar <= 'Z' )
         {
            testChar = (char)( testChar - 'A' + 'a' );
         }

         return testChar;
      }

      /** 
       * Overrides Object.toString, provides raw data from object
       */
      @Override
      public String toString()
      {
         return "State Name: " + state + " (" + captial + "), "
               + "Population: " + population;
      }

}

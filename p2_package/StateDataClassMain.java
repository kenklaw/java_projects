package p2_package;


public class StateDataClassMain
{
   private final static char COMMA = ',';

   public static void main(String[] args)
   {
      GenericDataMgmtClass<StateDataClass> gSC;
      StateDataClass stateData;
      String[] testData = new String[ 10 ];
      String tempStr;
      int arrayCapacity = 60;
      int index = 0;
      String fileName = "stateData.txt";

      // title
      System.out.println( "\nGenericArrayClass Data Testing\n");

      // set up test data
      testData[ 0 ] = "State Name: Rhode Island (Providence), Population: 1057315";
      testData[ 1 ] = "State Name: Ohio (Columbus), Population: 11689442";
      testData[ 2 ] = "State Name: New Jersey (Trenton), Population: 9032873";
      testData[ 3 ] = "State Name: California (Sacramento), Population: 39557045";
      testData[ 4 ] = "State Name: Delaware (Dover), Population: 967171";
      testData[ 5 ] = "State Name: New York (Albany), Population: 19542209";
      

      // access data from file
      // test initialization constructor, appendItem, resize 
      System.out.println( "Data Retrieval from file - Begin");         
      gSC = getData( fileName, arrayCapacity );
      

      if( gSC != null )
      {
         System.out.println( "Data Retrieval from file - Success");          

         index = 1;

         // remove all but 10 items
         while( gSC.getCurrentSize() > 10 )  
         {
            stateData = gSC.removeData( 0 );

            // Test for data accessed and removed
            System.out.format( "%2d: %s removed\n", 
                  index, stateData.toString() ); 

            index++;
         }

         try
         {
            // Test accessItemAt
            System.out.println( "\nTesting accessItem:");

            System.out.println( "\tState data: " 
                  + gSC.accessItemAt( 1 ).toString() + " tested.");
            tempStr = gSC.accessItemAt( 1 ).toString(); 
            assert tempStr.equals( testData[ 1 ] ) == true;

            System.out.println( "\tState data: " 
                  + gSC.accessItemAt( 2 ).toString() + " tested.");
            tempStr = gSC.accessItemAt( 2 ).toString(); 
            assert tempStr.equals( testData[ 2 ] ) == true;

            System.out.println( "\tState data: " 
                  + gSC.accessItemAt( 3 ).toString() + " tested.");
            tempStr = gSC.accessItemAt( 3 ).toString(); 
            assert tempStr.equals( testData[ 3 ] ) == true;

            System.out.println( "\tState data: " 
                  + gSC.accessItemAt( 4 ).toString() + " tested.");
            tempStr = gSC.accessItemAt( 4 ).toString(); 
            assert tempStr.equals( testData[ 4 ] ) == true;
         }

         catch( AssertionError ae )
         {
            System.out.print( "\t#################### " );
            System.out.print( "ACCESS ITEM ERROR: " );
            System.out.println( ae + " ####################" );                
         }

      }

      else
      {
         System.out.println("\nERROR: First Data access failure - Program aborted." );            
      }

      // reload data from file
      System.out.println( "\nData Retrieval from file - Begin");         
      gSC = getData( fileName, arrayCapacity );

      if( gSC != null )
      {
         System.out.println( "Data Retrieval from file - Success");          

         gSC.runBubbleSort();  // default sort, by name, forward

         System.out.println( "\nAfter Bubble Sort: ");

         index = 0;

         while( index < gSC.getCurrentSize() )
         {
            System.out.format( "%2d: %s\n", index + 1, 
                  gSC.accessItemAt( index ) );

            index++;
         }                          
   
         // reload data from file
         System.out.println( "\nData Retrieval from file - Begin");         
         gSC = getData( fileName, arrayCapacity );

         // reload data from file
         System.out.println( "\nData Retrieval from file - Begin");         
         gSC = getData( fileName, arrayCapacity );

         if( gSC != null )
         {
            System.out.println( "Data Retrieval from file - Success");          

            gSC.runSelectionSort();

            System.out.println( "\nAfter Selection Sort: ");

            index = 0;

            while( index < gSC.getCurrentSize() )
            {
               System.out.format( "%2d: %s\n", index + 1, 
                     gSC.accessItemAt( index ) );

               index++;
            }
         }

         // reload data from file
         System.out.println( "\nData Retrieval from file - Begin");         
         gSC = getData( fileName, arrayCapacity );

         if( gSC != null )
         {
            System.out.println( "Data Retrieval from file - Success");          

            gSC.runShellSort();

            System.out.println( "\nAfter Shell Sort: ");

            index = 0;

            while( index < gSC.getCurrentSize() )
            {
               System.out.format( "%2d: %s\n", index + 1, 
                     gSC.accessItemAt( index ) );

               index++;
            }
         }

      }

      else
      {
         System.out.println("\nERROR: Second Data Access Failure - Program Aborted");
      }

      System.out.println( "\n --- End of Program--- " );         
   }

   /**
    * Local method uploads data character by character,
    * parses characters, and loads into StateDataClass
    * @param fileName name of file in local directory required for upload
    * 
    * @param setCapacity directs method to set capacity
    * of generic array
    * 
    * @return returns generic array holding StateDataClass data
    */
   public static GenericDataMgmtClass<StateDataClass> 
   getData( String fileName, int setCapacity )
   {
      StateDataClass stateDataClassObj;
      GenericDataMgmtClass<StateDataClass> arrayClassObj 
      = new GenericDataMgmtClass<StateDataClass>( setCapacity );
      File_Input_Class fileInObj = new File_Input_Class();

      String stateName, stateAbbrev;
      long statePop;

      // open file, test for success
      if( fileInObj.openInputFile( fileName ) )
      {
         // prime loop
         stateName = fileInObj.getString( COMMA );

         stateAbbrev = fileInObj.getString( COMMA );

         statePop = fileInObj.getLong();

         // loop to end of file
         while( !fileInObj.checkForEndOfFile() )
         {
            stateDataClassObj
            = new StateDataClass( stateName, stateAbbrev, statePop );

            arrayClassObj.appendItem( stateDataClassObj );
            stateName = fileInObj.getString( COMMA );

            stateAbbrev = fileInObj.getString( COMMA );

            statePop = fileInObj.getLong();
         }
      }

      else
      {
         return null;             
      }

      return arrayClassObj;
   }

}

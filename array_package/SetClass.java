package array_package;


public class SetClass
{

   public static final int DEFAULT_ARRAY_CAPACITY = 10;

   int[] setArray;
   int arrayCapacity;
   int arraySize;

  
   /**
    * Default constructor
    * 
    * Initializes set array but sets power set array to null
    */
   public SetClass()
   {     
      arraySize = 0;      
      arrayCapacity = DEFAULT_ARRAY_CAPACITY;
      //initialize setArray to the DEFAULT_ARRAY_CAPACITY
      setArray = new int[ DEFAULT_ARRAY_CAPACITY ];
   }

   /**
    * Allows specification of set array capacity
    *
    * @param initialCapacity integer that specifies array capacity
    */
   public SetClass( int initialCapacity )
   {
      arraySize = 0;     
      arrayCapacity = initialCapacity;     
      setArray = new int [ initialCapacity ];
   }

   /**
    *
    * Duplicates copied set class
    *
    * @param copied SetClass object to be copied
    */
   public SetClass( SetClass copied )
   {
      int index;   
      this.arraySize = copied.arraySize;      
      this.arrayCapacity = copied.arrayCapacity;

      //initialize setArray to the copied arrayCapacity
      this.setArray = new int [ copied.arrayCapacity ];
      
      for( index = 0; index < this.arraySize; index++ )
      {
         //set the setArray index to the copiedArray index
         this.setArray[ index ] = copied.setArray[ index ];
      }
   }

   /**
    * @param item integer value to be added to set
    */
   public void addItem( int item )
   {
      //call checkForResize, check if array needs to be resize
      checkForResize();

      //check if array contains the item thats going to be added
      if( !hasElement( item ))
      {
         //if item is not in the array, add it
         this.setArray[ arraySize ] = item;
        
         this.arraySize += 1;
      }
   }

   /**
    * @return boolean report that resize was conducted
    */
   private boolean checkForResize()
   {
      int index;

      //check if array is at the capacity
      if( this.arraySize == this.arrayCapacity )
      {
         //if array is at capacity, then double the array
         this.arrayCapacity *= 2;

         //set a new array to the doubled capacity
         int [] doubledArray = new int[ arrayCapacity ];

         for( index = 0; index < this.arraySize; index++ )
         {
            //set the doubledArray index to the value at setArrays index
            doubledArray[ index ] = this.setArray[ index ];
         }

         //set the setArray equal to the doubledArray
         this.setArray = doubledArray;
         
         return true;
      }
      
      return false;
   }

   /**
    * @param other SetClass data with which intersection is found
    *
    * @return SetClass object with intersection of two sets
    */
   public SetClass findIntersection( SetClass other )
   {
      int index;      
      int intersectionValue;

      //create a setClass object
      SetClass intersectionSet = new SetClass();
      
      for( index = 0; index < arraySize; index++ )
      {
         //set the intersectionValue to the setArray index value
         intersectionValue = this.setArray[ index ];
         //check if the other arrays contain the intersectionValue
         if( other.hasElement( intersectionValue ))
         {
            //add the intersectionValues to the intersectionSet
            intersectionSet.addItem( intersectionValue );
         }
      }
      
      return intersectionSet;
   }

   /**
    * @param other SetClass data with which union is found
    *
    * @return SetClass object with union of two sets
    */
   public SetClass findUnion( SetClass other )
   {
      int index;
      int unionValue;

      //create a unionSet using a new SetClass object
      SetClass unionSet = new SetClass(this);
      
      for( index = 0; index < other.arraySize; index++ )
      {
         //set the unionnValue to the setArray index value
         unionValue = other.setArray[ index ];
         //add the intersectionValues to the intersectionSet
         unionSet.addItem( unionValue ); 
      }

   return unionSet;

   }

   /**
    * Finds relative complement of THIS set in given other set
    *
    * @param other SetClass object from which THIS SetClass items
    * will be removed
    *
    * @return SetClass object with data as specified
    */
   public SetClass findComplement( SetClass other )
   {         
      int index;
      
      for( index = 0; index < this.arraySize; index++ )
      {
         //check if the other array has the same value at the index
         if( other.hasElement( setArray[ index ] ))
         {
            //remove the value at the other index
            other.removeValue( setArray[ index ] );
         }
      }
      //return the other array
      return other;
   }

   /**
    * Tests to indicate if integer value is one
    * of the set elements
    *
    * @param testElement integer element to be found in set
    *
    * @return boolean result of test
    */
   public boolean hasElement( int testElement )
   {      
      int index;
      
      for( index = 0; index < arraySize; index++ )
      {
         //check if the array index contains the test element
         if( this.setArray[ index ] == testElement )
         {                  
            return true;
         }
      }

      return false;
   }


   /**
    * Tests to indicate if set is subclass of another given set
    *
    * @param other SetClass object to be tested
    * if THIS set is a subset of it
    *
    * @return boolean result of test
    */
   public boolean isSubsetOf( SetClass other )
   {        
      int index;         
      int count = 0;
      
      for( index = 0; index < other.arraySize; index++ )
      {
         //check if other array has the indexed element
         if( other.hasElement( index ))
         {
            count++;
         }
      }
      //return count == arraySize
      return (count == other.arraySize);
   }

   /**
    * Removes value at given index;
    * moves all succeeding data down in array
    *
    * @param indexToRemove integer index of element value to remove
    */
   private void removeAtIndex( int indexToRemove )
   {   
      int index;
      
      for( index = indexToRemove; index < this.arraySize; index++ )
      {
         //set the array value to be removed to the array value after it
         this.setArray[ index ] = this.setArray[ index + 1 ];
      }

      this.arraySize --;
   }

   /**
    * Removes value if it is found in set
    *
    * @param valToRemove integer value to be removed
    *
    * @return boolean result of operation success
    */
   public boolean removeValue( int valToRemove )
   {       
      int index;

      if( hasElement( valToRemove ))
      {               
         for( index = 0; index < this.arraySize; index++ )
         {
            //check if the indexed value is the index to remove
            if( this.setArray[ index ] == valToRemove )
            {                        
               removeAtIndex( index );
                          
               return true;
            }
         }
      }
      
      return false;
   }

   /**
    * @param startValue integer value indicates starting value
    *
    * @param numItems integer number of items to load
    *
    * @param incrementBy integer value used to specify increment
    * if INCREMENTED characteristic is set
    */
   public void loadItems( int startValue, int numItems, int incrementBy )
   {
      int index, runningValue = startValue;

      for( index = 0; index < numItems; index++ )
      {
         addItem( runningValue );

         runningValue += incrementBy;
      }
            
   }

   /**
    * Provides list of set array elements
    * as comma-delimited string
    */   
   public String toString()
   {
      int index;
      String outString = "";

      for( index = 0; index < arraySize; index++ )
      {
         if( index > 0 )
         {
            outString += ", ";
         }

         outString += setArray[ index ];
      }

      return outString;
   }
}
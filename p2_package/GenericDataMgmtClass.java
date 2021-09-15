package p2_package;

public class GenericDataMgmtClass<GenericData extends Comparable<GenericData>> 
{
   public static final int DEFAULT_CAPACITY = 10; 
   private Object[] localArray; 
   private int arraySize;
   private int arrayCapacity;


   /**
    * 
    * @param capacity maximum capacity specification for the array
    */
   public GenericDataMgmtClass( int capacity )
   {  
      arraySize = 0;
      arrayCapacity = capacity;
      localArray = new Object[ arrayCapacity ];
   }

   /**
    * @param accessIndex index of requested element value 
    *
    * @return accessed value if successful, null if not
    */
   @SuppressWarnings("unchecked")
   public GenericData accessItemAt( int accessIndex )
   { 
      GenericData indexValue; 
      
      if( accessIndex < arraySize  && accessIndex >= 0)
      {
         indexValue = ( GenericData ) localArray[ accessIndex ];
            
         return indexValue;
      }

      return null;
   }

   /**
    * Appends item to end of array, if array is not full, 
    * e.g., no more values can be added
    * 
    * @param newValue value to be appended to array
    * 
    * @return Boolean success if appended, or failure if array was full
    */
   public boolean appendItem( GenericData newValue )
   {
      //check if array if full
      if( !isFull() )
      {
         //append item if array is not full
         localArray[ arraySize ] = newValue;
      
         arraySize++;
         //return true if successful
         return true;
      }

      //return false if unsuccessful
      return false;
   }

   /**
    * Clears array of all valid values by setting array size to zero, 
    * values remain in array but are not accessible
    */
   public void clear()
   {
      arraySize = 0;
   }

   /**
    * Gets current capacity of array
    * 
    * @return capacity of array
    */
   public int getCurrentCapacity()
   {
      return arrayCapacity;
   }

   /**
    * Gets current size of array
    * 
    * @return size of array
    */
   public int getCurrentSize()
   {
      //return size of the array
      return arraySize;
   }

   /**
    * Inserts item to array at specified index if array is not full
    *
    * Value is inserted at given index, all data from that 
    * index to the end of the array is shifted up by one
    * 
    * @param insertIndex index of element into which value is to be inserted
    * 
    * @param newValue value to be inserted into array
    * 
    * @return boolean success if inserted, or failure if array was full
    */
   public boolean insertData( int insertIndex, GenericData newValue )
   {
      //check if array is full
      if( !isFull() )
      {
         int index; 

         for( index = insertIndex; index < arraySize; index++ )
         {
            localArray[ insertIndex + 1 ] = localArray[ index ];
         }
         //insert value into index
         localArray[ insertIndex ] = newValue;
         
         arraySize++;
         
         return true;
      }
      //return false otherwise
      return false;
   }

   /**
    * Tests for size of array equal to zero, no valid values stored in array
    * 
    * @return boolean result of test for full
    */
   public boolean isEmpty()
   {
      return arraySize == 0;
   }

   /**
    * Tests for size of array equal to capacity, no more values can be added
    * 
    * @return boolean result of test for full
    */
   public boolean isFull()
   {
      return arraySize == arrayCapacity;
   }

   /**
    * Removes item from array at specified index if index within 
    * array size bounds
    * 
    * Each data item from the element immediately above the remove index 
    * to the end of the array is moved down by one element
    * 
    * @param removeIndex index of element value to be removed
    * 
    * @return removed value if successful, null if not
    */
   @SuppressWarnings( "unchecked" )
   public GenericData removeData( int removeIndex )
   {
      int index;
      GenericData removedValue = null; 
     
      if( removeIndex >= 0 && removeIndex < arraySize )
      {
         for( index = removeIndex; index < arraySize; index++ )
         {
            //set removedValue to the localArray[ removeIndex ]
            removedValue = ( GenericData ) localArray[ removeIndex ];
            //set every index after the removed index to index + 1
            localArray[ index ] = localArray[ index + 1 ];
         }
         
         arraySize--;
         
         return removedValue;                    
      }
      
      return null;
   }

   /**
    * Resets array capacity, copies current size and current size 
    *
    * Method will not resize capacity below current array capacity, returns 
    * false if this is attempted, true otherwise
    * 
    * @param newCapacity new capacity to be set; must be larger than current
    * capacity
    * 
    * @return boolean condition of resize success or failure
    */
   public boolean resize( int newCapacity )
   {
      int index;
      Object[] referenceArray = new Object [ newCapacity ];
      
      if( newCapacity > arrayCapacity )
      {
         //set the member capacity to the new capacity
         arrayCapacity = newCapacity;
         //for loop to go through the array
         for( index = 0; index < arraySize; index++ )
         {
            //copy localArray index value to reference array
            referenceArray[ index ] = localArray[ index ];
         }
         
         //set localArray to referenceArray
         localArray = referenceArray;
         
         return true;  
      }

      return false;
   }

   /**
    * Sorts elements using the bubble sort algorithm
    */
   @SuppressWarnings("unchecked")
   public void runBubbleSort()
   {
      //set a boolean swapped to true
      boolean swapped = true;
      GenericData firstIndex, secondIndex;
      int index;

      //while swapped is true
      while( swapped )
      {  
         swapped = false;
         
         for( index = 0; index < arraySize - 1; index++ )
         {
            //set firstIndex to the first index
            firstIndex = ( GenericData ) localArray[ index ];
            //set secondIndex to the second index
            secondIndex = ( GenericData ) localArray[ index + 1 ];
            //check if firstIndex compared to secondIndex > 0
            if( firstIndex.compareTo( secondIndex ) > 0 )
            {
               swapElements( index, index + 1 );
   
               swapped = true;
            }
         }
      }
   }


   /**
    * Sorts elements using the selection sort algorithm
    */
   @SuppressWarnings( "unchecked" )
   public void runSelectionSort()
   {
      GenericData firstIndex, secondIndex; 
      int outerIndex, innerIndex, lowerIndex;
      
      for( outerIndex = 0; outerIndex < arraySize - 1; outerIndex++ )
      {
         lowerIndex = outerIndex;
         
         for( innerIndex = outerIndex + 1; innerIndex < arraySize; innerIndex++  )
         {
            firstIndex = ( GenericData ) localArray[ lowerIndex ];
            secondIndex = ( GenericData ) localArray[ innerIndex];
            
            if( firstIndex.compareTo( secondIndex ) > 0 )
            {
               lowerIndex = innerIndex;
            }
         }
         swapElements( outerIndex, lowerIndex );
      }
   }

   /**
    * Uses Shell's sorting algorithm to sort Generic Data in an array 
    * of Objects
    */
   @SuppressWarnings( "unchecked" )
   public void runShellSort()
   {
      int gap, gapPassIndex, insertionIndex;
      GenericData tempItem, testItem;
      boolean continueSearch;
      for( gap = arraySize / 2; gap > 0; gap /= 2 )
      {
         for( gapPassIndex = gap; gapPassIndex < arraySize; gapPassIndex++ )
         {
            tempItem = (GenericData)localArray[ gapPassIndex ];
            insertionIndex = gapPassIndex;
            continueSearch = true;
            
            while( continueSearch && insertionIndex >= gap )
            {
               testItem = (GenericData)localArray[ insertionIndex - gap ];
               
               if( testItem.compareTo( tempItem ) >  0 )
               {
                  localArray[ insertionIndex ] = localArray[ insertionIndex - gap ];  

                  insertionIndex -= gap;
               }
               else
               {
                  continueSearch = false;
               }
            } 
            
            localArray[ insertionIndex ] = tempItem;
         }  
      }     
   }

   /**
    * 
    * @param oneIndex index of one of two elements to be swapped
    * 
    * @param otherIndex index of second of two elements to be swapped
    */
   private void swapElements( int oneIndex, int otherIndex )
   { 
      Object temporary = localArray[ oneIndex ];      
      localArray[ oneIndex ] = localArray[ otherIndex ];     
      localArray[ otherIndex ] = temporary;
   }
}

//Sorting Algorithms

class test{

    public static void main(String args[]){

        int[] arr = new int[10];

        arr[0] = 10;
        arr[1] = 9;
        arr[2] = 8;
        arr[3] = 7;
        arr[4] = 6;
        arr[5] = 5;
        arr[6] = 4;
        arr[7] = 3;
        arr[8] = 2;
        arr[9] = 1;

        display(arr);
        
        System.out.println(" ");

        bubble(arr);

    }

    //Display contents of an int array
    public static void display(int[] array){

        int i;

        for(i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }


    //Swap two int elements
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swapped " + a + " " + b);
        
        
    }



    // bubble sort the array
    public static void bubble(int[] array)
    {
 
        int i, j;
        int num_swaps = 0;
        
        //for loop to go through the array
        for( i = 0; i < array.length - 1; i++ )
        {
            for(j = 0; j < array.length - i - 1; j++)
            {
                if(array[j] > array[j+1])
                {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    num_swaps++;
                    System.out.println("Swap " + num_swaps + " " + array[j] + " " + array[j+1]);
                    
                }
                
            } 
        }
        display(array);        
    }

}


// }

// public void runBubbleSort()
// {
//    //set a boolean called swapped to true
//    boolean swapped = true;
//    GenericData firstIndex, secondIndex;
//    int index;
//    //while swapped is true
//    while( swapped )
//       {
//          //set swapped to false
//          swapped = false;
//          //for loop to go through the array
//          for( index = 0; index < arraySize - 1; index++ )
//             {
//                //set firstIndex to the first index
//                firstIndex = ( GenericData ) localArray[ index ];
//                //set secondIndex to the second index
//                secondIndex = ( GenericData ) localArray[ index + 1 ];
//                //check if firstIndex compared to secondIndex > 0
//                if( firstIndex.compareTo( secondIndex ) > 0 )
//                   {
//                      //swap first and second index
//                      swapElements( index, index + 1 );
//                      //set swapped to true
//                      swapped = true;
//                   }
//             }
//       }
// }

// /**
// * Sorts elements using the insertion sort algorithm
// * <p>
// * The data is sorted using the compareTo method of the given data set; 
// * the compareTo method decides the key and the order resulting
// */
// @SuppressWarnings( "unchecked" )
// public void runInsertionSort()
// {
//    //set up generic data 
//    GenericData firstIndex, secondIndex;
//    //set up index counters
//    int innerIndex, outerIndex;
//    //initialize outer index to 0
//    outerIndex = 0;
//    //loop through the array 
//    while( outerIndex < arraySize - 1 )
//       {
         
//          firstIndex = removeData( outerIndex+ 1 );
         
//          //for loop to go though the inner array
//          for( innerIndex = 0; innerIndex < outerIndex; innerIndex++ )
//             {
//                //
//                secondIndex = (GenericData) localArray[ innerIndex ];
//                //check if the innerIndex should be after innerIndex + 1
//                if( firstIndex.compareTo( secondIndex ) >= 0 )
//                   {
//                      insertData( innerIndex, firstIndex ); 
//                      //swap elements
//                      //swapElements(innerIndex , innerIndex + 1);
//                   }
//                else if( firstIndex.compareTo( secondIndex ) >= 0 &&
//                         innerIndex == outerIndex )
//                   {
//                      insertData( outerIndex, firstIndex ); 
//                   }
//             }
//          //increase the outerIndex
//          outerIndex++;
//       }
// }

// /**
// * Sorts elements using the selection sort algorithm
// * <p>
// * The data is sorted using the compareTo method of the given data set; 
// * the compareTo method decides the key and the order resulting
// */
// @SuppressWarnings( "unchecked" )
// public void runSelectionSort(int[] array)
// {
//    //set  up generic data
//    GenericData firstIndex, secondIndex;
//    //set up needed variables
//    int outerIndex, innerIndex, lowerIndex;
//    //for loop to go through the outer index
//    for( outerIndex = 0; outerIndex < arraySize - 1; outerIndex++ )
//       {
//          lowerIndex = outerIndex;
//          //for loop to go through the inner index
//          for( innerIndex = outerIndex + 1; innerIndex < arraySize; 
//                innerIndex++  )
//             {
//                //setting up GenericData types
//                firstIndex = ( GenericData ) localArray[ lowerIndex ];
//                secondIndex = 
//                      ( GenericData ) localArray[ innerIndex];
//                //comparing the variables
//                if( firstIndex.compareTo( secondIndex ) > 0 )
//                   {
//                      lowerIndex = innerIndex;
//                   }
//             }
//          //swap elements
//          swapElements( outerIndex, lowerIndex );
//       }
// }

// /**
// * Uses Shell's sorting algorithm to sort Generic Data in an array 
// * of Objects
// * <p>
// * Shell's sorting algorithm is an optimized insertion algorithm
// */
// @SuppressWarnings( "unchecked" )
// public void runShellSort()
// {
//    int gap, gapPassIndex, insertionIndex;
//    GenericData tempItem, testItem;
//    boolean continueSearch;
//    for( gap = arraySize / 2; gap > 0; gap /= 2 )
//       {
//          for( gapPassIndex = gap; 
//                gapPassIndex < arraySize; gapPassIndex++ )
//             {
//                tempItem = (GenericData)localArray[ gapPassIndex ];
//                insertionIndex = gapPassIndex;
//                continueSearch = true;
               
//                while( continueSearch && insertionIndex >= gap )
//                   {
//                      testItem 
//                      = (GenericData)localArray[ insertionIndex - gap ];
                     
//                      if( testItem.compareTo( tempItem ) >  0 )
//                         {
//                            localArray[ insertionIndex ] 
//                                  = localArray[ insertionIndex - gap ];  

//                            insertionIndex -= gap;
//                         }
//                      else
//                         {
//                            continueSearch = false;
//                         }
//                   }  // end search loop
//                localArray[ insertionIndex ] = tempItem;
//             }  // end list loop
//       }  // end gap size setting loop   
// }

// /**
// * Swaps one element in the local array at a given index with another
// * element in the array at the other given element
// * 
// * @param oneIndex index of one of two elements to be swapped
// * 
// * @param otherIndex index of second of two elements to be swapped
// */
// private void swap( int one, int two )
// {
//    //create a temporary object to store oneIndex value
//    Object temporary = localArray[ one ];
//    //set oneIndex to otherIndex
//    localArray[ one ] = localArray[ two ];
//    //set otherIndex to temporary value 
//    localArray[ two ] = temporary;
// }
// }
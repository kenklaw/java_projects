import jdk.internal.jshell.tool.resources.l10n;

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

       // bubble(arr);

        System.out.println(" ");

        //insertion_sort(arr);

        //getSmallest(arr);


        System.out.println("selection sort:");
        selectionSort(arr);

    }

    //Display contents of an int array
    public static void display(int[] array)
    {

        int i;

        for(i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }


    //Swap two int elements
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        System.out.println("swapped " + arr[a] + " " + arr[b]);
               
    }



    // bubble sort the array
    public static void bubble(int[] array)
    {
 
        int first_index, second_index;
        int num_swaps = 0;
        
        //for loop to go through the array
        for( first_index = 0; first_index < array.length - 1; first_index++ )
        {
            for(second_index = 0; second_index < array.length - first_index - 1; second_index++)
            {
                if(array[second_index] > array[second_index+1])
                {
                    
                    int temp = array[second_index];
                    array[second_index] = array[second_index+1];
                    array[second_index+1] = temp;

                    num_swaps++;
                    //System.out.println("Swap " + num_swaps + " " + array[second_index] + " " + array[second_index+1]);
                    
                }
                
            } 
        }
        System.out.println("Total number of swaps for bubblesort " + num_swaps);
        display(array);        
    }





    
    public static void insertion_sort(int[] array){

        int front_index,back_index,key;
        int num_swaps = 0;

        // front index traverses the array checking the next value "key"
        for(front_index = 1; front_index < array.length; front_index++){
            key = array[front_index];
            back_index = front_index-1;

            // 
            while(back_index >= 0 && array[back_index] > key){
                array[back_index + 1] = array[back_index];
                back_index = back_index -1;


            }
            array[back_index + 1] = key;
            num_swaps++;
            
        }

        System.out.println("Total number of swaps for insertion sort " + num_swaps);
        display(array);        

    }


    public static void selectionSort(int[] array){

        int i, j;
        int smallest = 0;
        int num_swaps = 0;
        int current_id;
        int temp;
        
        
        for (i = 0; i < array.length - 1; i++)
        {
            current_id = i;

            for(j = i + 1; j < array.length; j++)
            {
                if(array[j] < array[current_id]){
                    current_id = j;
                }

                //spaw the found min with the first element
                temp = array[current_id];
                array[current_id] = array[i];
                array[i] = temp;

            }

            
        }
        //System.out.println("Total number of swaps for selection sort " + num_swaps);
        display(array);
    }


    public static void getSmallest(int[] array){

        // start at the beginning of the array next value is current_value + 1
        int current_value = 0;
        int i;

        for (i = 0; i < array.length - 1; i++)
        {
            if(array[i] < array[current_value]){
                current_value = array[i];
            }
        }
        System.out.println("the smallest value in the array is " + array[current_value]);

      
    }





}



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
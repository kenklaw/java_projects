// Java arrays Interview Practice


class array_refresh{

    // prints contents of the array
    public static void print_array(int[] array){

        int index;

        System.out.print("Array contents ");

        for(index = 0; index < array.length; index++){

            System.out.print(array[index] + " ");
        }
    }

    // prints value at index given an array and an index
    public static void get_value_at_index(int[] array, int index){

        System.out.print("value at index " + index + " is " + array[index]);
    }

    // prints the array in reverse order
    public static void reverse_array(int[] array){

        int index;

        System.out.print("Reversed array ");

        for(index = array.length - 1; index >= 0; index --){

            System.out.print(array[index] + " ");
        }
    }

    // replaces value in array when given array, index, and value
    public static void replace_at_index(int[] array, int index, int value){

        array[index] = value;

        System.out.println("Array index " + index +  " replaced with " + value);

        print_array(array);
    }

    // replaces index given with a 0 in the array
    public static void remove_at_index(int[] array, int index){

        array[index] = 0;

        System.out.println("Index value "+ index + " removed and replaced with a 0 ");

        print_array(array);
    }

    // if a 0 is found in the array, shifts all other values to the left
    public static void shift_array(int[] array){

        int index;

        if(empty_spaces(array) == 0){
                
            System.out.println("No empty spaces array cannot be shifted ");
        }

        for(index = 0; index < array.length; index++){

            if(array[index] == 0 && index + 1 < array.length){

                array[index] = array[index + 1];
                array[index + 1] = 0;
            }
            
        }
        System.out.println("After shifting ");
        print_array(array);
    }

    // counts the number of 0's in the array returns 0 or count
    public static int empty_spaces(int[] array){

        int index;
        int count = 0;

        for(index = 0; index < array.length; index++){

            if(array[index] == 0){
                count++;
            }

        }
        return count;
    }

    // replaces all elements of the array with 0's
    public static void remove_all(int[] array){

        int index;

        for(index = 0; index < array.length; index++){

            array[index] = 0;
        }

        System.out.println("Zero'd out array");
        print_array(array);
    }

    // returns the smallest value in the array
    public static int get_min(int[] array){

        int index;
        int min = array[0]; 

        for(index = 0; index < array.length; index++){
            
            if(min > array[index]){

                min = array[index];
            }  
        }
        //System.out.print("The smallest value in the array is " + min); // Testing
        return min;
    }

    // returns the largest value in the array
    public static int get_max(int[] array){

        int index;
        int max = array[0]; 

        for(index = 0; index < array.length; index++){
            
            if(max < array[index]){

                max = array[index];
            }  
        }
        //System.out.print("The largest value in the array is " + max); // Testing
        return max;
    }

    // returns the index of a desired given value
    // otherwise returns 0 and error statement
    public static int get_index_of(int[] array, int value){

        int index;

        for(index = 0; index < array.length; index++){

            if(array[index] == value){
                // System.out.print(" the value " + value + " was found at index " + index); // Testing
                return index;
            }
        }
        System.out.println("ERROR: A value could not be found in the array returning 0 in its place");
        return 0;
    }

    // Swaps min and max values in the array
    public static void swap_min_max(int[] array){

        int min = get_min(array);
        int max = get_max(array);

        int min_index = get_index_of(array, min);
        int max_index = get_index_of(array, max);

        array[min_index] = max;
        array[max_index] = min;

        print_array(array);

    }

    // replaces based on the value in the array not index
    public static void overwrite_by_value(int[] array, int value, int replace){

        int value_index = get_index_of(array, value);

        array[value_index] = replace;

        System.out.print(value + " was replaced with " + replace + "\n");

        print_array(array);

        
    }


    


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// Simple Quick Tester for array_refresh
public static void main(String[] args){

    int[] array = new int[10];

    int i;

    for(i = 0; i < array.length; i++){

        array[i] = i + 1;
    }

    print_array(array);

    System.out.println("\n");

    get_value_at_index(array, 2);

    System.out.println("\n");

    reverse_array(array);

    System.out.println("\n");

    replace_at_index(array, 5, 100);

    System.out.println("\n");

    remove_at_index(array, 5);

    System.out.println("\n");

    shift_array(array);

    System.out.println("\n");

    replace_at_index(array, 9, 6);

    System.out.println("\n");

    shift_array(array);

    System.out.println("\n");

    get_min(array);

    System.out.println("\n");

    get_max(array);

    System.out.println("\n");

    get_index_of(array, 6);

    swap_min_max(array);

    System.out.println("\n ");

    overwrite_by_value(array, 5, 25);

    System.out.println("\n ");

    overwrite_by_value(array, 6, 25);

    


}

}
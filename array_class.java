// array refresh 2

public class array_class{

    private int array_capacity = 50;
    private int[] array = new int[array_capacity];
    private int array_size = 10;

    public void get_cap_and_size(){

        System.out.println("Array Size : " + array_size);
        System.out.println("Array Capacity: " + array_capacity);
    }

    public void generate_random_array(){

        int index;

        for (index = 0; index < array_size; index++){

            array[index] = (int)(Math.random() * 10) + 10;
        }
    }

    public void print_array(){

        int index;

        for(index = 0; index < array_size; index++){

            System.out.print(array[index] + " ");
        }
    }

    public int get_value_at_index(int index){

        if(index < array_size){
            return array[index];
        }

        System.out.println("Illigal index passed returning 0");
        return 0;
    }

    public void remove_at_index(int value){

        int index;

        if(value < array_size){

            for(index = value; index < array_size -1; index ++){
                
                array[index] = array[index +1];
            }
            array_size --;
        }
        
    }

    public boolean array_has_value(int value){

        boolean found = false;
        int index;

        for(index = 0; index < array_size; index++){

            if(array[index] == value){

                found = true;
            }
        }

        return found;
    }

    public void insert_at_end(int value){

        if(array_size < array_capacity){

            array[array_size] = value;

            array_size ++;
        }

    }

    public String linear_search(int value){

        boolean found = false;
        int index;
        String index_string = "";

        System.out.print("The value was found at index: ");

        for(index = 0; index < array_size; index ++){

            if(array[index] == value){

                found = true;

                System.out.print(index + " ");

                index_string += index + " ";

            }
        }

        if(!found){

            index_string = "No items were found";

            System.out.print(index_string);
        }

        return index_string;
    }

    //Binary seach for array requires array is in ascending order
    public void binary_search(int value){

        int low = 0;
        int high = array_size -1;
        int middle;
        boolean found = false;

        while(low <= high){

            middle = (high + low) / 2;

            if(array[middle] < value){
                low = middle + 1;
            }
            else if(array[middle] > value){
                high = middle - 1;
            }
            else{
                System.out.println("Value " + value + " found at index " + middle);
                found = true;
                low = high + 1;
            }
        }

        if(!found){
            System.out.println("Error value not in array");
        }

    }

    public void swap(int a, int b){

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }

    public void bubble_sort_ascending(){

        int index;
        int index_two;

        for(index = array_size -1; index > 0; index--){

            for(index_two = 0; index_two < index; index_two++){

                if(array[index_two] > array[index_two + 1]){

                    swap(index_two, index_two + 1);
                }
            }
        }
        System.out.println("After bubble sort ascending ");
        print_array();
    }

    public void bubble_sort_desending(){

        int index;
        int index_two;

        for(index = array_size -1; index > 0; index--){

            for(index_two = 0; index_two < index; index_two++){

                if(array[index_two] < array[index_two + 1]){

                    swap(index_two, index_two + 1);
                }
            }
        }
        System.out.println("After bubble sort desending");
        print_array();
    }

    public void selection_sort_ascending(){

        int index;
        int index_two;
        int min;

        for(index = 0; index < array_size; index++){

            min = index;

            for(index_two = index; index_two < array_size; index_two++){

                if(array[min] > array[index_two]){

                    min = index_two;
                }
            }

            swap(index, min);   
        }

        System.out.println("Array sorted with selection sort ascending ");
        print_array();
    }

    public void selection_sort_desending(){

        int index;
        int index_two;
        int min;

        for(index = 0; index < array_size; index++){

            min = index;

            for(index_two = index; index_two < array_size; index_two++){

                if(array[min] < array[index_two]){

                    min = index_two;
                }
            }

            swap(index, min);   
        }

        System.out.println("Array sorted with selection sort desending");
        print_array();
    }

    public void insertion_sort_ascending(){
        
        int index;
        int index_two;
        int to_insert;

        for(index = 1; index < array_size; index ++){

            index_two = index;
            to_insert = array[index];

            while((index_two > 0) && (array[index_two-1] > to_insert)){

                array[index_two] = array[index_two-1];
                index_two --;
            }

            array[index_two] = to_insert;

        }
        System.out.println("Array sorted with insertion sort ascending");
        print_array();
    }

    public void insertion_sort_desending(){
        
        int index;
        int index_two;
        int to_insert;

        for(index = 1; index < array_size; index ++){

            index_two = index;
            to_insert = array[index];

            while((index_two > 0) && (array[index_two-1] < to_insert)){

                array[index_two] = array[index_two-1];
                index_two --;
            }

            array[index_two] = to_insert;

        }
        System.out.println("Array sorted with insertion sort desending");
        print_array();
    }

    // shell sort uses inner, outer and interval 
    public void shell_sort(){

        int inner, outer, temp;

        int interval = 1;

        while(interval <= (array_size / 3)){

            interval = (interval * 3) + 1;   
        }
            while(interval > 0){

                for(outer = interval; outer < array_size; outer++){

                    temp = array[outer];
                    inner = outer;
                
                    while(inner > interval -1 && array[inner - interval] >= temp){

                        array[inner] = array[inner - interval];
                        inner -= interval;
                    }
                    array[inner] = temp;
                }

                interval = (interval -1) / 3;
            }
        System.out.println("After shell sort ");
        print_array();

    }

    // quicksort algorithm uses partition and recursion
    public void quick_sort(int left, int right){

        if(right - left <= 0){
            return;
        }
        else{
            int pivot = array[right];

            int pivot_location = partition_array(left, right, pivot);

            quick_sort(left, pivot_location -1);
            quick_sort(pivot_location + 1, right);
        }
        
        
    }

    public int partition_array(int left, int right, int pivot){

        int left_pointer = left -1;
        int right_pointer = right;

        while(true){

            while(array[++left_pointer] < pivot);

            while(right_pointer > 0 && array[--right_pointer] > pivot);

            if(left_pointer >= right_pointer){

                break;
            }
            else{
                swap(left_pointer, right_pointer);
            }
        }
        swap(left_pointer, right);
        return left_pointer;
    }

    

    

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////TESTING////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main (String[] args){

        array_class array = new array_class();

        array.get_cap_and_size();

        array.generate_random_array();

        array.print_array();

        System.out.println("\n");

        System.out.print(array.get_value_at_index(1));

        array.remove_at_index(1);

        System.out.println("\n");

        array.print_array();

        array.insert_at_end(100);

        System.out.println("\n");

        array.print_array();

        System.out.println("\n");

        array.linear_search(17);

        System.out.println("\n");

        array.bubble_sort_ascending();

        System.out.println("\n");

        array.binary_search(10);

        System.out.println("\n");

        array.bubble_sort_desending();

        array.generate_random_array();

        System.out.println("\n");

        System.out.println("Creating new random array");
        array.print_array();

        System.out.println("\n");
        array.selection_sort_ascending();

        System.out.println("\n");
        array.selection_sort_desending();

        array.generate_random_array();

        System.out.println("\n");

        array.insertion_sort_ascending();

        System.out.println("\n");

        array.insertion_sort_desending();

        System.out.println("\n");
        array.generate_random_array();
        System.out.println("New random array before shell sort");
        array.print_array();

        System.out.println("\n");
        array.shell_sort();
        
        System.out.println("\n");

        System.out.println("Array before qicksort");
        array.generate_random_array();
        array.print_array();
        System.out.println("\n");

        int size = array.array_size - 1;
        System.out.println("After quicksort");
        array.quick_sort(0, size );
        array.print_array();

    }
}
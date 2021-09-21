import java.util.Arrays;

// Simple Queue refresh
// Queue is a FIFO structure
// First element added is the first to be removed

public class array_queue{

    private String[] array;
    private int array_size;
    private int front = 0;
    private int back = 0;
    private int num_items = 0;

    // initalize queue
    array_queue(int size){

        array_size = size;

        array = new String[size];

        Arrays.fill(array, "-1");

    }

    // add item to the queue
    public void enqueue(String value){

        if(num_items + 1 <= array_size){

            array[back] = value;

            back++;

            num_items++;

            System.out.println("value " + value + " was added to the queue");
        }
        else{
            System.out.println("Error: Queue is full");
        }
    }

    // Remove the first item added to the queue
    public void dequeue(){

        if(num_items > 0){

            System.out.println("value " + array[front] + " was removed from the queue");

            array[front] = "-1";

            front++;

            num_items--;
        }
        else{
            System.out.println("Error: Queue is empty");
        }
    }

    // peek at the element that was first added to the queue
    public void peek(){

        System.out.println("the first value in the queue is " + array[front]);
    }

    // Simple print for testing
    public void print_array(){

        int index;

        for(index = 0; index < array_size; index++){

            System.out.print(array[index] + " ");
        }
    }

    // places values in queue highest (first) to lowest(last)
    // largest value is at the front of the queue
    public void priority_queue(String value){

        int index;

        if(num_items == 0){

            enqueue(value);
        }
        else{

            for(index = num_items -1; index >= 0; index--){

                if(Integer.parseInt(value) > Integer.parseInt(array[index])){

                    array[index + 1] = array[index];
                }
                else{
                    break;
                }
            }
            array[index+1] = value;
            back++;
            num_items++;

        }
    }




                // Testing
    public static void main(String[] args){

        array_queue array = new array_queue(10);

        array.enqueue("5");

        array.enqueue("10");

        array.print_array();

        System.out.println("\n");
        array.peek();

        System.out.println("\n");
        array.dequeue();


        array.print_array();

        System.out.println("\n");
        array.peek();

        array_queue priority_array = new array_queue(10);

        priority_array.priority_queue("9");
        priority_array.priority_queue("14");
        priority_array.priority_queue("8");
        priority_array.priority_queue("11");
        priority_array.priority_queue("6");

        System.out.println("\n");
        priority_array.print_array();

        System.out.println("\n");
        priority_array.peek();

        System.out.println("\n");
        priority_array.dequeue();


    }


}
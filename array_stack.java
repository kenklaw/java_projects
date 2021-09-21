import java.util.Arrays;

// Simple Stack refresh
// Stack is a LIFO structure
// Element added last is the element to remove

public class array_stack{

    private String[] array;
    private int array_size = 10;
    //private int array_capacity = 50;
    private int top_stack = -1;

    //initalize the stack
    array_stack(int size){

        array_size = size;
        array = new String[size];
        Arrays.fill(array, "-1");
    }

    // push a value onto the stack
    public void push(String value){

        if(top_stack + 1 < array_size){

            top_stack++;

            array[top_stack] = value;

        }
        else{
            System.out.println("Stack is full cannot add value");
        }

        print_array();

        System.out.print("value " + value + " was added to the stack");
    }

    // Remove the last item pushed onto the stack LIFO
    public String pop(){

        if(top_stack >= 0){

            print_array();

            System.out.print("value " + array[top_stack] + " was popped to the stack");

            array[top_stack] = "-1";

            return array[top_stack--];
        }
        else{
            print_array();

            System.out.println("Array is empty cannot pop ");

            return "-1";
        }
    }

    // return the last pushed "top" item on the stack
    public String peek(){

        print_array();

        System.out.println("value " + array[top_stack] + " is at the top of the stack");

        return array[top_stack];
    }

    // Simple print for testing
    public void print_array(){

        int index;

        for(index = 0; index < array_size; index++){

            System.out.println(array[index] + " ");

            if(array[index +1] == "-1"){

                index = array_size;
            }
        }
    }

    // Remove all values from the stack
    public void pop_all(){

        int index;

        for(index = top_stack; index >= 0; index--){

            pop();
        }
    }




                // Testing

    public static void main (String[] args){

        array_stack array = new array_stack(10);

        array.push("10");

        array.push("9");

        System.out.println("\n");

        array.print_array();

        System.out.println("\n");

        array.peek();

        System.out.println("\n");

        array.pop();

        System.out.println("\n");

        array.push("12");

        System.out.println("\n");

        array.push("14");

        System.out.println("\n");

        array.pop_all();

        System.out.println("\n");

        System.out.println("Stack is cleared if -1 is returned");
        array.print_array();
    }

}
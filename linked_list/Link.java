// Linked lists refresh


// Link class to create new link nodes
public class Link{

    public String item;
    public int price;

    public Link next;

    public Link(String item, int price){

        this.item = item;
        this.price = price;

    }

    public void display(){

        System.out.println(item + " : " + price);
    }


    public String toString(){

        return item;
    }


    public static void main(String[] args){

        linked_list list = new linked_list();

        list.insert_first("burger", 20);
        list.insert_first("pizza", 10);
        list.insert_first("wrap", 5);

        list.traverse();

        //list.traverse();

        System.out.print("\n");
        System.out.print("removing pizza ");
        list.remove("pizza");
        System.out.print("\n");

        list.traverse();

        System.out.print("\n");
        System.out.print("removing first --> wrap ");
        list.remove_first();
        System.out.print("\n");

        list.traverse();
    }
}


// Linked list class to handle node operations
class linked_list{

    public Link first_node;

    // initalize a new list with no nodes/links
    linked_list(){

        first_node = null;
    }

    // set head to null to empty the list
    public boolean is_empty(){

        return(first_node == null);
    }

    // create a new node set current head to next 
    // insert new value in head/first position
    public void insert_first(String item, int price){

        Link new_node = new Link(item, price);

        new_node.next = first_node;

        first_node = new_node;

    }

    // remove first node by setting current.next to head
    public Link remove_first(){

        Link reference = first_node;

        if(!is_empty()){

            first_node = first_node.next;
        }
        else{
            System.out.println("List is empty cannot remove");

        }

        return reference;

    }

    // display all nodes in list
    public void traverse(){

        Link node = first_node;

        while(node != null){

            node.display();

            node = node.next;

        }
    }

    // find item in the list given an item name
    public Link find(String item){

        Link node = first_node;

        if(!is_empty()){

            while(node.item != item){

                if(node.next == null){
                    return null;
                }
                else{
                    node = node.next;
                }

            }
        }
        else{
            System.out.println("Error: List is empty");
        }
        return node;
    }

    // remove item in the list given an item name
    public Link remove(String item){

        Link current = first_node;
        Link previous = first_node;

        while(current.item != item){

            if(current.next == null){
                return null;
            }
            else{
                previous = current;

                current = current.next;
            }

        }
        if(current == first_node){

            first_node = first_node.next;
        }
        else{

            previous.next = current.next;
        }

        return current;
    }

}






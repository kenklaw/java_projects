// Doubly Linked list refresh


// Link class for DLL to create new link nodes
// each node has next and previous
public class Link{

    public String item;
    public int price;

    public Link next;
    public Link prev;

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

        list.insert_in_order("pie", 20);
        list.insert_in_order("cake", 40);
        list.insert_in_order("pizza", 10);

        list.insert_after("beer", 16, 20);

        list.traverse();

        Iterator nodes = new Iterator(list);

        nodes.current.display();

        System.out.println(nodes.has_next());

        nodes.next();

        nodes.current.display();

        System.out.println("\n");
        System.out.println("iterating to next");
        nodes.next();
        nodes.current.display();

        System.out.println("\n");
        System.out.println("iterating to previous");
        nodes.previous.display();

    }
}


// Linked list class to handle node operations
class linked_list{

    public Link first_link;
    public Link last_link;

    // set head to null to empty the list
    public boolean is_empty(){

        return(first_link == null);
    }

    // create a new node set current head to next 
    // insert new value in head/first position
    public void insert_first(String item, int price){

        Link new_node = new Link(item, price);

        if(is_empty()){

            last_link = new_node;
        }
        else{

            first_link.prev = new_node;
        }
        
        new_node.next = first_link;

        first_link = new_node;

    }

    // create a new node insert new value at last position
    public void insert_last(String item, int price){

        Link new_node = new Link(item, price);

        if(is_empty()){

            first_link = new_node;
        }
        else{
            last_link.next = new_node;

            new_node.prev = last_link;
        }
        
        last_link = new_node;

    }

    // insert new link after a given key
    public boolean insert_after(String item, int price, int key){

        Link new_node = new Link(item, price);
        Link current = first_link;

        while(current.price != key){

            current = current.next;

            if(current == null){
                return false;
            }
        }
        
        if(current == last_link){
            new_node.next = null;
            last_link = new_node;
        }
        else{
            new_node.next = current.next;
            current.next.prev = new_node;
        }

        new_node.prev = current;
        current.next = new_node;
        return true;

    }

    // coompares link keys to place the links in the DLL in ascending order
    public void insert_in_order(String item, int price){

        Link new_node = new Link(item, price);

        Link previous = null;
        Link current = first_link;

        while((current != null) && (price > current.price)){

            previous = current;
            current = current.next;
        }
        if(previous == null){
            first_link = new_node;
        }
        else{
            previous.next = new_node;
        }

        new_node.next = current;
    }

    // remove first node by setting current.next to head
    public Link remove_first(){

        Link reference = first_link;

        if(!is_empty()){

            first_link = first_link.next;
        }
        else{
            System.out.println("List is empty cannot remove");

        }

        return reference;

    }

    // display all nodes in list
    public void traverse(){

        Link node = first_link;

        while(node != null){

            node.display();

            node = node.next;

        }
    }

    // find item in the list given an item name
    public Link find(String item){

        Link node = first_link;

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

        Link current = first_link;
        Link previous = first_link;

        while(current.item != item){

            if(current.next == null){
                return null;
            }
            else{
                previous = current;

                current = current.next;
            }

        }
        if(current == first_link){

            first_link = first_link.next;
        }
        else{

            previous.next = current.next;
        }

        return current;
    }

}


// Iterator class to traverse links of the DLL
class Iterator{

    Link current;
    Link previous;

    linked_list nodes;

    Iterator(linked_list nodes){

        this.nodes = nodes;
        current = nodes.first_link;
        previous = nodes.last_link;
    }

    public boolean has_next(){

        if(current.next != null){
            return true;
        }
        return false;
    }

    public Link next(){

        if(has_next()){

            previous = current;
            current = current.next;

            return current;
        }

        return null;
    }

    public void remove(){

        if(previous == null){
            nodes.first_link = current.next;
        }
        else{
            previous.next = current.next;
        }
        if(current.next == null){
            current = nodes.first_link;
            previous = null;
        }
        else{
            current = current.next;
        }

    }


}






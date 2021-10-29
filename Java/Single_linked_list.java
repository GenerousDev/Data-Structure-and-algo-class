//Node as a data type is the pointer 
class LinkedList {
    Node head; // head of the list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        
        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) { 
            data = d;
            next = null;
        }
    }
    public void deleteNodeAtPosition(int position){
            if( head == null){
                return;
            }
            
            Node temp =  head;
            if (position == 0){
                head = temp.next;
                return;
            }
    }

    //print out all value of the linked list 
    public void printlist(){
        Node n = head;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    // push a new node to the head 
    public void push(int data){
        Node new_node  = new Node(data);

        // there is no next pointing to head
        new_node.next = head ;
        head =  new_node;
    }

    public void deleteNode(int key){
        Node temp = head , prev = null ; 

        // if head exist and its the node we want to delete
        if(temp != null && temp.data == key){
            head = temp.next;
            return;
        }

        // some other node in the sequence 
        while(temp != null &&  temp.data != key){
            prev = temp;
            temp =  temp.next;
        }

        if(temp == null){
            return;
        }
// for any of the cases unlink the node from the linked list
        prev.next = temp.next;
    }
   
    //Add a node after a given node 
    public void Insertafter(Node prev_node,int new_data){
        if(prev_node == null){
            System.out.print("The given previous node cannot be null ");
            return;
        }

        //at this point next of new_node is null
        Node new_node = new Node(new_data);
        //prev_node[|next] pointing to another node before new is placed in front 
        //prev_node[|next] -> new_node[new_data|next]

        // Make next of new Node as next of prev node 
        new_node.next = prev_node.next;

        // make next of prev_node as new_node 
        prev_node.next =  new_node;

    }

    //Add a node at the end of the sequence 
    public void Append(int new_data){
        Node new_node = new Node (new_data);
        if( head == null ){
            head = new Node(new_data);
            return;
        }
        new_node.next = null;

        // Else transeverse to the last node
        Node last = head;
        while( last.next !=null){
            last = last.next;
        }

        last.next = new_node;
        return;
    }
    public static void main(String[] args) {
        LinkedList llist =  new LinkedList();
        llist.head = new Node(1);
        Node second =  new Node(2);
        Node third  =  new Node(3);

        llist.head.next = second;
        second.next = third;
        // third.next = null;

        llist.printlist();
    }
}
import java.util.NoSuchElementException;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public static class Node{
        int value;
        Node next;
        Node(int number, Node nextNode){
            value = number;
            next = nextNode;
        }
    }

    public void addFirst(int value){
        if(head == null){
            head = new Node(value, null);
            tail = head;
        }
        else{
            head = new Node(value, head);
        }
        size++;
    }

    public void removeFirst() {
        if (size == 0) //empty list
        { throw new NoSuchElementException();}
        else if(head == tail)  //one node in list check
        {    head = tail = null; }
        else //any other list
        {    head = head.next;}
        size--;
    }

    public void addLast(int value){
        if(size == 0){
           addFirst(value);
        }
        else{
            tail.next = new Node(value, null);
            tail = tail.next;
            size++;
        }
    }

    public void removeLast(){
        if(size < 2){
            removeFirst();
        }
        else{
            Node current = head;
            while(current.next != tail)
                current = current.next;
            tail = current;
            tail.next = null;
            size--;
            }
        }
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node current = head;
        while (current != null) {
            sb.append(current.value + " ");
            current = current.next;
        }
        sb.append("]");
        return new String(sb);
    }
      /*  String linkedListString = "";
        Node current = head;
        while(current != null){
            linkedListString += (current + "\n");
        }

        return linkedListString;
    }*/

      public int get(int idx){

          if(idx < 0 || idx > size - 1)
              throw new NoSuchElementException();

          Node getValue = head;
          for(int i = 0; i < idx; i++){
              getValue = getValue.next;
          }
          return getValue.value;
      }

      public void reverse(){
          if(size < 2)
              return;
          Node p1 = null, p2 = head, p3 = head.next;

          while (p3 != null){
              p2.next = p1;
              p1 = p2;
              p2 = p3;
              p3 = p3.next;
          }
          p2.next = p1; //fix the last node
          tail = head;
          head = p2;
      }

      public static void main(String args[]){

          LL list = new LL();
          list.addFirst(3);
          list.addFirst(2);
          list.addFirst(1);

          list.addLast(4);
          list.addLast(5);
          list.addLast(6);

          System.out.println("Should see 1-6: " + list.toString());

          list.removeFirst();
          list.removeLast();
          System.out.println("Should see 2-5: " + list.toString());

          System.out.println("Should be 4: " + list.get(2));

          list.reverse();

          System.out.println("Should be 5-2: " + list.toString());

      }

    }



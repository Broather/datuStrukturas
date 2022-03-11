package dataStr.SEMINARS_2;

public class MyLinkedList {
    private MyLinkedListNode first = null;
    private MyLinkedListNode last = null;
    private int counter = 0;

    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Nosakidro vai RAM atmiņā iespējams izveidot jaunu MyLinkedListNode objektu
     * 
     * @return atbilde uz jautājumu "Vai RAM atmiņa ir pilna?"
     */
    public boolean isFull() {
        try {
            MyLinkedListNode newNode = new MyLinkedListNode(69);
            return false;
        } catch (OutOfMemoryError e) {
            return true;
        }
    }

    /**
     * @return skaits elementu LinkedList sarakstā
     */
    public int howManyElements() {
        return counter;
    }

    public void add(int value) {
        MyLinkedListNode newNode = new MyLinkedListNode(value);
        newNode.setNext(null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        counter++;
    }

    public void add(int value, int position) throws Exception {

        if (position >= 0 && position <= counter) {
            MyLinkedListNode newNode = new MyLinkedListNode(value);
            if (isEmpty()) {
                newNode.setNext(null);
                first = newNode;
                last = newNode;
            } else if (position == 0) {
                newNode.setNext(first);
                first = newNode;

            } else if (position == counter) {
                newNode.setNext(null);
                last.setNext(newNode);
                last = newNode;
            } else {
                // find the element before position and element at position
                // name them temp1 and temp2
                MyLinkedListNode temp1 = first;
                for (int i = 0; i < position - 1; i++) {
                    temp1 = temp1.getNext();
                }
                MyLinkedListNode temp2 = temp1.getNext();
                // set links between the 3 nodes appropriately
                newNode.setNext(temp2);
                temp1.setNext(newNode);
            }
            counter++;
        } else {
            Exception e = new Exception("Elementu nevar pievienot jo nav atbilstosa pozicija");
            throw e;
        }
    }
    

}

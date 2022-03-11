package dataStr.SEMINARS_2;

public class MyLinkedListNode {
    private int value;
    private MyLinkedListNode next;

    public MyLinkedListNode(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyLinkedListNode [value=" + value + "]";
    }
}

package com;

public class MyLinkedList1<K> {

    public INode head;
    public INode tail;

    public MyLinkedList1() {
        this.head = null;
        this.tail = null;
    }
    public <K> INode search(K key) {
        INode<K> tempNode = head;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }


    public <V, K> void append(INode<K> myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null){
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }
}

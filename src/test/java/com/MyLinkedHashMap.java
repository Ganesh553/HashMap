package com;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
    private final int numBuckets;
    ArrayList<Object> numBucketArray;

    public MyLinkedHashMap(){
        this.numBuckets = 10;
        this.numBucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i<=numBuckets;i++){
            this.numBucketArray.add(null);
        }

    }

    public V get(K key) {
        int index = this.getnumBuckets(key);
        MyLinkedList1<K> myLinkedList = (MyLinkedList1<K>) this.numBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K,V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    private int getnumBuckets(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    public void add(K key, V value) {
        int index = this.getnumBuckets(key);
        MyLinkedList1 myLinkedList1 = (MyLinkedList1) this.numBucketArray.get(index);
        if (myLinkedList1 == null){
            myLinkedList1 = new MyLinkedList1<>();
            this.numBucketArray.set(index, myLinkedList1);
        }
        MyMapNode<K,V> myMapNode = (MyMapNode<K, V>) myLinkedList1.search(key);
        if (myMapNode == null){
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList1.append((INode)myMapNode);
        }else {
            myMapNode.setValue(value);
        }
    }
    @Override
    public String toString(){
        return "MyLinkedListNode{" + numBucketArray + '}';
    }
}

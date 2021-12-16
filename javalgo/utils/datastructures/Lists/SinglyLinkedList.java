package datastructures.Lists;

import java.util.StringJoiner;

public class SinglyLinkedList {
    
    private Node head;

    private int size;

    public SinglyLinkedList(){
        head=null;
        size=0;
    }

    public SinglyLinkedList(Node head,int size){
        this.head=head;
        this.size=size;
    }

    public void insertHead(int x){
        insertNth(x,0);
    }
    
    public void insert(int data){
        insertNth(data,size);
    }

    public void insertNth(int data,int position){
        checkBounds(position,0,size);
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            size++;
            return;
        }else if(position==0){
            newNode.next=head;
            head=newNode;
            size++;
            return;
        }
        Node cur=head;
        for(int i=0; i < position - 1; i++){
            cur=cur.next;
        }
        newNode.next=cur.next;
        cur.next=newNode;
        size++;
    }

    public void deleteHead(){
        deleteNth(0);
    }

    public void delete(){
        deleteNth(size-1);
    }

    public void deleteNth(int position){
        checkBounds(position,0,size-1);
        if(position==0){
            Node destory=head;
            head=head.next;
            destory=null;
            size--;
            return;
        }
        Node cur=head;
        for(int i=0; i < position-1; i++){
            cur=cur.next;
        }

        Node destory=cur.next;
        cur.next=cur.next.next;
        destory=null;

        size--;
    }

    public void checkBounds(int position,int low,int high){
        if(position > high || position < low){
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    public void clear(){
        Node cur = head;
        while(cur!=null){
            Node prev=cur;
            cur=cur.next;
            prev=null;
        }
        head=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public int count(){
        int count=0;
        Node cur=head;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }

    public boolean search(int key){
        Node cur=head;
        while(cur!=null){
            if(cur.value==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public Node getHead(){
        return this.head;
    }

    public int getNth(int index){
        checkBounds(index,0,size-1);
        Node cur=head;
        for(int i=0; i < index; i++){
            cur=cur.next;
        }
        return cur.value;
    }

    @Override
    public String toString(){
        StringJoiner joiner=new StringJoiner("->");
        Node cur=head;
        while(cur!=null){
            joiner.add(cur.value + "");
            cur=cur.next;
        }
        return joiner.toString();
    }

    public static void main(String[] args){
        SinglyLinkedList list=new SinglyLinkedList();
        assert list.isEmpty();
        assert list.size()==0 && list.count()==0;
        assert list.toString().equals("");

        list.insertHead(5);
        list.insertHead(7);
        list.insertHead(10);
        list.insert(3);
        list.insertNth(1, 4);
        assert list.toString().equals("10->7->5->3->1");
    }

}


class Node{
    int value;
    Node next;

    Node(){}

    Node(int value){
        this(value,null);
    }

    Node(int value,Node next){
        this.value=value;
        this.next=next;
    }
}
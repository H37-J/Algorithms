package datastructures.Lists;

public class RemoveDuplicateNodes {
    
    public Node deleteDuplicates(Node head){
        Node sentinel=new Node(0,head);

        Node pred= sentinel;

        while(head != null){
            if(head.next!=null && head.value==head.next.value){
                while(head.next!=null && head.value==head.next.value){
                    head=head.next;
                }
                pred.next=head.next;
            }else{
                pred=pred.next;
            }
            head=head.next;
        }
        return sentinel.next;
    }
}

package datastructures.queue;

public class PriorityQueue {
    
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueue(int size){
        maxSize=size;
        queueArray=new int[size];
        nItems=0;
    }

    public void insert(int value){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }else{
            int j=nItems-1;
            if(j > 0 && queueArray[j] > value){
                queueArray[j+1]=queueArray[j];
                j--;
            }
            queueArray[j+1]=value;
            nItems++;
        }
    }

    public int remove(){
        return queueArray[nItems];
    }

    public int peek(){
        return queueArray[nItems-1];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }

    public int getSize(){
        return nItems;
    }

    public static void main(String[] args) {
        PriorityQueue myQueue = new PriorityQueue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);

        for (int i = 3; i >= 0; i--)
          System.out.print(
              myQueue.remove() + " "); // will print the queue in reverse order [10, 5, 3, 2]
    
      }


    
}

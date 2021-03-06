package search;

import java.util.Random;
import java.util.stream.Stream;

public class LinearSearch implements SearchAlgorithm{

    @Override
    public <T extends Comparable<T>> int find(T[] array,T value){
        for(int i=0; i<array.length; i++){
            if(array[i].compareTo(value)==0){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        Random r=new Random();
        int size=200;
        int maxElement=100;
        Integer[] integers=Stream.generate(()->r.nextInt(maxElement)).limit(size).toArray(Integer[]::new);

        Integer Found=integers[r.nextInt(size-1)];

        LinearSearch search=new LinearSearch();
        int atIndex=search.find(integers,Found);

        System.out.println(
            String.format(
                "Should be found: %d. Found %d at index %d. An array length %d",
                Found, integers[atIndex], atIndex, size));
    }
}

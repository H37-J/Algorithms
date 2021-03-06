package search;

import static java.lang.String.format;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BinarySearch implements SearchAlgorithm{
    
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key){
        return search(array, key, 0, array.length);
    }

    private <T extends Comparable<T>> int search(T array[], T key, int left, int right){
        if(right < left) return -1;

        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);

        if(comp == 0){
            return median; //찾았을시 종료
        }else if(comp < 0){
            return search(array, key, left, median - 1);
        }else{
            return search(array, key, median + 1, right);
        }
    }

    public static void main(String[] args){
        Random r = ThreadLocalRandom.current();

        int size = 100;
        int maxElement = 100;

        Integer[] integers = IntStream.generate(() -> r.nextInt(maxElement))
        .limit(size)
        .sorted()
        .boxed()
        .toArray(Integer[]::new);

        int shouldBeFound = integers[r.nextInt(size-1)];

        BinarySearch search = new BinarySearch();
        int atIndex = search.find(integers,shouldBeFound);

        System.out.println(integers[atIndex]);
    }
}

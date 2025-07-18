package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {

        // Using normal condition
        long startTime = System.currentTimeMillis();
        List<Integer> list= Stream.iterate(1, x -> x+1)
                .limit(20000)
                .collect(Collectors.toList());

        List<Integer> factorialList = list.stream()
                .map(ParallelStreams::square)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken by Sequential Stream : " + (endTime-startTime) + " ms");


        // Using parallel Streams
        startTime = System.currentTimeMillis();
        List<Integer> factorialUsingParallelStreams = list.parallelStream()
                .map(ParallelStreams::square).collect(Collectors.toList());

        endTime = System.currentTimeMillis();
        System.out.println("Total Time taken by Parallel Stream : " + (endTime-startTime) + " ms");
        System.out.println(factorialUsingParallelStreams);

    }

    public static int square(int n){
       return n*n;
    }
}

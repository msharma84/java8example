package interview;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertMapToList {

    public static void main(String[] args) {

        Map<String,Integer> myMap = new HashMap<>();
        myMap.put("IN",1000);
        myMap.put("US",900);
        myMap.put("UK",800);
        myMap.put("JP",700);

        // Converting Key
        Set<String> keySet = myMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        System.out.println("Using traditional : "+keyList);
        // Using streams

        List<String> listOfKeys = myMap.keySet().stream().collect(Collectors.toList());
        System.out.println("Using Fumctional programming : "+listOfKeys);

        // Converting Values
        Collection<Integer> collectionValue =  myMap.values();
        List<Integer> valuesList = new ArrayList<>(collectionValue);
        System.out.println("Using traditional : "+valuesList);

        // Using streams
        List<Integer> listOfValues = myMap.values().stream().collect(Collectors.toList());
        System.out.println("Using Fumctional programming : "+listOfValues);
    }
}

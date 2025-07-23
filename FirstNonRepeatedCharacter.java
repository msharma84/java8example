package interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String : ");

        String input = scanner.nextLine();
        input = input.replace(" ","");

        Map<Character,Integer> myMap = new LinkedHashMap<>();
        for(char ch : input.toCharArray()){
            myMap.put(ch, myMap.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : myMap.entrySet()){
            if(entry.getValue() ==1){
                System.out.println("First Non repeated char : "+entry.getKey());
                break;
            }
        }
    }
}

package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeMaps {

    public static void main(String[] args) {

        Map<String,Integer> map1 = new HashMap<>();
        map1.put("apple",1);
        map1.put("banana",2);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("orange",3);
        map2.put("mango",4);

        Map<String,Integer> mergedMap = Stream
                .concat(map1.entrySet().stream(),map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));
        mergedMap.forEach((key,value) -> System.out.println(key + " : "+ value));
    }
}

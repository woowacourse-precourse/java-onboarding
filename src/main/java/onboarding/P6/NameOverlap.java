package onboarding.P6;

import java.util.*;
import java.util.stream.Collectors;

public class NameOverlap {

    public static List<String> OverlapResult(List<List<String>> forms) {
        NameSplit(forms);
        List<String> nameoverlapresult = NameOverlap();
        return EmailSort(nameoverlapresult);
    }
    private static Map<String, List<String>> map1 = new HashMap<>();

    private static void NameSplit(List<List<String>> name){
        for(List<String>form : name){
            String username = form.get(1);
            for(int i=0; i < username.length()-1; i++){
                String splitword = username.substring(i, i+2);

                List<String> list = map1.getOrDefault(splitword, new ArrayList<>());
                list.add(form.get(0));
                map1.put(splitword, list);

            }
        }

    }
    private static List<String> NameOverlap(){
        return map1.values().stream()
                .filter(list -> list.size() >=2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<String> EmailSort(List<String> overlapemail){
        return overlapemail.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }
}

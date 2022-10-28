package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Map<String, Integer> twoLetters = makeTwoLetters(forms);


        return getResult(forms, twoLetters.keySet());
    }

    static Map<String, Integer> makeTwoLetters(List<List<String>> forms){
        Map<String, Integer> map = new HashMap<>();

        for(List list : forms){
            String str = (String)list.get(1);
            putDevidedIntoMap(str, map);
        }
        deleteNoneDuplicates(map);

        return map;
    }

    static void putDevidedIntoMap(String str, Map<String, Integer> map){
        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
    }

    static void deleteNoneDuplicates(Map<String, Integer> map){

        Set<String> deleteKeys = new HashSet<>();

        for ( Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() < 2){
                deleteKeys.add(entry.getKey());
            }
        }

        deleteKeys.stream().forEach( s -> map.remove(s));
    }

    static List<String> getResult(List<List<String>> forms, Set<String> set){

        Set<String> tmpSet = new HashSet<>();

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            for (List<String> list : forms){
                if (list.get(1).contains(str)) {
                    tmpSet.add(list.get(0));
                }
            }
        }

        List<String> result = new ArrayList<>(tmpSet);
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return result;
    }
}

package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> subNameSpace = new HashMap<>();

        for(List<String> form : forms) addSubName(form.get(1), subNameSpace);
        Set<String> duplicatedSubNames = duplicatedSubNameSet(subNameSpace);
        subNameSpace.clear();

        Set<String> answer = new TreeSet<>();
        for(List<String> x : forms) {
            String email = x.get(0);
            String name  = x.get(1);
            if (isCorrectedDomain(email) && isDuplicatedName(name, duplicatedSubNames))
                answer.add(email);
        }

        return new ArrayList<>(answer);
    }

    static Set<String> subNameCreator(String name){
        Set<String> set = new HashSet<>();
        for(int i=0; i<name.length()-1; i++){
            String subName = name.substring(i,i+2);
            set.add(subName);
        }
        return set;
    }

    static void addSubName(String name, Map<String, Integer> map){
        Set<String> subNames = subNameCreator(name);
        subNames.forEach(x->map.put(x, map.getOrDefault(x,0)+1));
    }

    static Set<String> duplicatedSubNameSet(Map<String, Integer> map) {
        Set<String> set = new HashSet<>();
        map.keySet().stream().filter(x->map.get(x)>1).forEach(set::add);
        return set;
    }

    static boolean isCorrectedDomain(String email) {
        return email.substring(email.length()-10).equals("@email.com");
    }

    static boolean isDuplicatedName(String name, Set<String> set) {
        Set<String> subNames = subNameCreator(name);
        long count = subNames.stream().filter(set::contains).count();
        return count != 0;
    }
}

package onboarding;

import java.util.*;

public class Problem6 {

    static private Map<String, Integer> repositoryOfPair;

    public static List<String> solution(List<List<String>> forms) {
        repositoryOfPair = new HashMap<>();

        for(List<String> form : forms) addPairToRepository(form.get(1));
        Set<String> duplicatedPairs = TransformDuplicatedPairSet();
        repositoryOfPair.clear();

        Set<String> answer = new TreeSet<>();
        for(List<String> x : forms) {
            String email = x.get(0);
            String name  = x.get(1);
            if (isCorrectedDomain(email) && hasDuplicatedPair(name, duplicatedPairs))
                answer.add(email);
        }

        return new ArrayList<>(answer);
    }

    static Set<String> pairCreator(String name){
        Set<String> set = new HashSet<>();
        for(int i=0; i<name.length()-1; i++){
            String pair = name.substring(i,i+2);
            set.add(pair);
        }
        return set;
    }

    static void addPairToRepository(String name){
        Set<String> pairNames = pairCreator(name);
        pairNames.forEach(x-> repositoryOfPair.put(x, repositoryOfPair.getOrDefault(x,0)+1));
    }

    static Set<String> TransformDuplicatedPairSet() {
        Set<String> set = new HashSet<>();
        repositoryOfPair.keySet().stream().filter(x-> repositoryOfPair.get(x)>1).forEach(set::add);
        return set;
    }

    static boolean isCorrectedDomain(String email) {
        return email.substring(email.length()-10).equals("@email.com");
    }

    static boolean hasDuplicatedPair(String name, Set<String> set) {
        Set<String> pariNames = pairCreator(name);
        long count = pariNames.stream().filter(set::contains).count();
        return count != 0;
    }
}

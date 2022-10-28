package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static Map<String, String> listToMap(List<List<String>> forms){
        Map<String, String> result = new HashMap<>();
        forms.stream().forEach(form -> result.put(form.get(0), form.get(1)));

        return result;
    }

    static boolean isSimilar(String name1, String name2){

        Stream<String> tokenStream = getTokens(name1).stream();
        Stream<String> containedTokens =  tokenStream.filter(token -> name2.contains(token));

        return containedTokens.count() > 0;

    }

    static List<String> getTokens(String name) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < name.length() - 1; i++) {
            String token = name.substring(i, i + 2);
            result.add(token);
        }

        return result;
    }

    static List<List<String>> getCombination(List<String> keys){
        List<List<String>> result = new ArrayList<>();
        int keyCnt = keys.size();

        for (int i = 0; i < keyCnt - 1; i++){
            String key1 = keys.get(i);
            List<String> remainKeys = keys.subList(i + 1, keyCnt + 1);
            remainKeys.stream().forEach(email -> result.add(List.of(key1, email)));
        }

        return result;
    }

}

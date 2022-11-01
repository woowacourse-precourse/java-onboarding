package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static List<String> tokenizer(String str) {
        return IntStream.rangeClosed(0, str.length() - 2)
            .mapToObj(i -> String.join("", Arrays.copyOfRange(str.split(""), i, i + 2)))
            .collect(Collectors.toList());
    }

    private static void appendMapValue(String key, String appendValue,
        HashMap<String, HashSet<String>> map) {
        HashSet<String> valueSet = map.getOrDefault(key, new HashSet<>());
        valueSet.add(appendValue);
        map.put(key, valueSet);
    }

    public static List<String> solution(List<List<String>> forms) {
        //key: token / value: email
        HashMap<String, HashSet<String>> userMap = new HashMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);
            List<String> tokens = tokenizer(nickname);
            tokens.forEach(token -> appendMapValue(token, email, userMap));
        }
        List<String> answer = List.of("answer");
        return answer;
    }
}

package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = getDuplicateNickname(forms);

        return answer;
    }

    private static List<String> getDuplicateNickname(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Map<String, TreeSet<String>> twoNameMap = getAllTwoLengthNameMap(forms);

        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for(int i = 1; i < nickname.length(); i++) {
                String twoLengthName = getSubString(nickname, i);

                if (twoNameMap.get(twoLengthName).size() > 1) {
                    result.add(email);
                    break;
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    private static Map<String, TreeSet<String>> getAllTwoLengthNameMap(List<List<String>> forms) {
        Map<String, TreeSet<String>> result = new TreeMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            for(int i = 1; i <nickname.length(); i++) {
                String name = getSubString(nickname, i);
                TreeSet<String> nameTreeSet = result.getOrDefault(name, new TreeSet<>());

                nameTreeSet.add(nickname);
                result.put(name, nameTreeSet);
            }
        }

        return result;
    }

    private static String getSubString(String nickname, int idx) {
        return nickname.substring(idx-1, idx+1);
    }
}

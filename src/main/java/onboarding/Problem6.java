package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    static class Duplicate {
        static Map<String, List<String>> passedMembers = new HashMap<>();

        public static List<String> twoLettersDuplicateCheck (List<String> form) {
            List<String> duplicateMember = new ArrayList<>();
            String nickName = form.get(1);
            for (int i = 0; i < nickName.length() - 1; i++) {
                String twoLetter = nickName.substring(i, i + 2);

                if (passedMembers.containsKey(twoLetter)) {
                    duplicateMember.add(passedMembers.get(twoLetter).get(0));
                    duplicateMember.add(form.get(0));
                } else {
                    passedMembers.put(twoLetter, form);
                }
            }
            return duplicateMember;
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        List<String> duplicateCheckResult = new ArrayList<>();
        for (List<String> form : forms) {
            duplicateCheckResult.addAll(Duplicate.twoLettersDuplicateCheck(form));
        }
        answer = duplicateCheckResult.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }

}

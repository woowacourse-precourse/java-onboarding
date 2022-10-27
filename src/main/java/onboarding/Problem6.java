package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static List<List<String>> forms;
    private static List<String> answer;
    private static Map<String, Integer> twoCharAndIndex;
    public static List<String> solution(List<List<String>> forms) {
        initialize(forms);
        makeEmailsOfDuplicatedName();
        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }

    private static void initialize(List<List<String>> forms) {
        Problem6.twoCharAndIndex = new HashMap<>();
        Problem6.forms = forms;
        Problem6.answer = new ArrayList<>();
    }

    private static void makeEmailsOfDuplicatedName() {
        for (int i=0; i<forms.size(); i++) {
            for (String twoChar : getTwoCharsAfterSplit(getNickname(i))) {
                if (twoCharAndIndex.containsKey(twoChar))
                    addEmailToAnswer(i, twoChar);
                twoCharAndIndex.put(twoChar, i);
            }
        }
    }

    private static List<String> getTwoCharsAfterSplit(String name) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<name.length()-1; i++) {
            result.add(name.substring(i, i+2));
        }
        return result;
    }

    private static void addEmailToAnswer(int index, String twoChar) {
        answer.add(getEmail(index));
        answer.add(getEmail(twoChar));
    }

    private static String getEmail(int index) {
        return forms.get(index).get(0);
    }

    private static String getEmail(String twoChar) {
        return forms.get(twoCharAndIndex.get(twoChar)).get(0);
    }

    private static String getNickname(int index) {
        return forms.get(index).get(1);
    }
}

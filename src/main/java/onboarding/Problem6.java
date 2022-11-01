package onboarding;

import java.util.*;

public class Problem6 {

    private static List<String> divideNameByTwoChars(List<String> form) {
        List<String> dividedName = new ArrayList<>();
        String name = form.get(1);
        int nameLength = name.length();
        for(int i = 0; i < nameLength - 1; i++) {
            dividedName.add(name.substring(i, i+2));
        }
        return dividedName;
    }
    private static List<String> findEmailsContainWord(List<List<String>> forms, String target, String compareWords) {
        List<String> email = new ArrayList<>();
        for (List<String> form : forms) {
            String name = form.get(1);
            if(name.contains(compareWords) && !target.equals(name)) {
                email.add(form.get(0));
            }
        }
        return email;
    }
    private static List<String> removeDuplicatedEmail(List<String> answer) {
        Set<String> set = new HashSet<>(answer);
        return new ArrayList<>(set);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> words;
        List<String> email;
        for(List<String> form: forms) {
            words = divideNameByTwoChars(form);
            for(String word: words) {
                email = findEmailsContainWord(forms, form.get(1), word);
                if(email.size() > 0) {
                    answer.addAll(email);
                    answer.add(form.get(0));
                }
            }
        }
        answer = removeDuplicatedEmail(answer);
        Collections.sort(answer);
        return answer;
    }
}
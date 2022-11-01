package onboarding;

import java.util.*;

public class Problem6 {
    /* 기능단위
    * 1. 이름을 2글자씩 분할 (divideNameByTwoChars)
    * 2. 1에서 2글자씩 분할한 글자가 forms의 name에 포함되어 있는 이메일 찾기 (findEmailContainWord)
    * 3. 2에서 구한 이메일들의 중복 제거 (removeDuplicatedEmail)
    * */

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
        Collections.sort(answer);
        return answer;
    }
}

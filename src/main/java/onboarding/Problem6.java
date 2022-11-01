package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static boolean checkOverlap(String first, String second) { //중복 여부 체크
        for (int i = 0; i < first.length() - 1 ; i++) {
            for (int j = 0; j < second.length() - 1; j++) {
                if (first.charAt(i) == second.charAt(j) && first.charAt(i+1) == second.charAt(j+1))
                    return true;
            }
        }
        return false;
    }

    public static List<String> emailClassific(List<List<String>> forms) { //이메일 분류
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                boolean isValid = checkOverlap(forms.get(i).get(1), forms.get(j).get(1));
                if (isValid) {
                    if (!answer.contains(forms.get(i).get(0)))
                        answer.add(forms.get(i).get(0));
                    if (!answer.contains(forms.get(j).get(0)))
                        answer.add(forms.get(j).get(0));
                }
            }
        }
        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer"); //연속되는 닉네임의 이메일 주소 담아야 함

        answer = emailClassific(forms); //forms 받아서 중복자 찾을거임
        Collections.sort(answer);

        return answer;
    }
}

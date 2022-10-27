package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    private static int check_domain(String email){
        if (!email.endsWith("@email.com")) //예외처리 0 : 이메일 형식에 부합하는지
            return (-1);
        if (email.length() < 11 || email.length() >= 20) // 예외처리 1 : email 길이 11~19
            return (-1);
        return (0);
    }
    private static int check_nickname(String nickname){
        if (!nickname.matches("^[ㄱ-ㅎ |ㅏ-ㅣ | 가-힣]*$")) // 예외처리 2 : nickname은 한글로만 구성됨
            return (-1);
        if (nickname.length() < 1 || nickname.length() >= 20) // 예외처리 3 : nickname 길이 1~19
            return (-1);
        return (0);
    }
    private static int check_email(List<List<String>> forms){
        int count = 0;
        for(List<String> items : forms) {
            count++;
            if (check_domain(items.get(0)) == -1 || check_nickname(items.get(1)) == -1)
                return (-1);
        }
        if (count < 1 || count > 10000)
            return (-1); // 예외처리 4 : 멤버의 number가 1~10000
        return (0);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> answer_rep = new ArrayList<>();
        String temp = "";
        if (check_email(forms) == -1)
            return (List.of(""));
        for (int i = 0; i < forms.size(); i++){
            get_two_letters(forms, answer_rep, i);
        }
        for (String email : answer_rep){
            if(!answer.contains(email))
                answer.add(email);
        }
        Collections.sort(answer);
        return answer;
    }

    private static void get_two_letters(List<List<String>> forms, List<String> answer_rep, int i) {
        String temp;
        for (int j = 0; j + 1< forms.get(i).get(1).length(); j++){
            temp = forms.get(i).get(1).substring(j,j+2);
            add_answer(forms, answer_rep, temp, i);
        }
    }

    private static void add_answer(List<List<String>> forms, List<String> answer_rep, String temp, int i) {
        for (int k = i + 1; k < forms.size(); k++){
            if (forms.get(k).get(1).contains(temp)) {
                answer_rep.add(forms.get(k).get(0));
                answer_rep.add(forms.get(i).get(0));
            }
        }
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem6 {
    private static boolean check_domain(String email){
        if (!email.endsWith("@email.com")) //예외처리 0 : 이메일 형식에 부합하는지
            return false;
        if (email.length() < 11 || email.length() >= 20) // 예외처리 1 : email 길이 11~19
            return false;
        return true;
    }
    private static boolean check_nickname(String nickname){
        if (!nickname.matches("^[ㄱ-ㅎ |ㅏ-ㅣ | 가-힣]*$")) // 예외처리 2 : nickname은 한글로만 구성됨
            return false;
        if (nickname.length() < 1 || nickname.length() >= 20) // 예외처리 3 : nickname 길이 1~19
            return false;
        return true;
    }
    private static boolean check_counts(int count) {
        if (count < 1 || count > 10000)// 예외처리 4 : 멤버의 number가 1~10000
            return false;
        return true;
    }
    private static boolean check_exceptions(List<List<String>> forms){
        int count = 0;
        for(List<String> items : forms) {
            count++;
            if (!check_domain(items.get(0)) || !check_nickname(items.get(1)))
                return false;
        }
        if (!check_counts(count))
            return false;
        return true;
    }

    private static List<String> find_answer(List<List<String>> forms) {
        List<String> answer_with_repetition = new ArrayList<>();
        for (int form_number = 0; form_number < forms.size(); form_number++){
            get_two_letters(forms, answer_with_repetition, form_number);
        }
        return answer_with_repetition;
    }

    private static void get_two_letters(List<List<String>> forms, List<String> answer_with_repetition, int form_number) {
        String two_letters;
        for (int str_loc = 0; str_loc + 1< forms.get(form_number).get(1).length(); str_loc++){
            two_letters = forms.get(form_number).get(1).substring(str_loc,str_loc+2);
            add_repetition_to_answer(forms, answer_with_repetition, two_letters, form_number);
        }
    }

    private static void add_repetition_to_answer(List<List<String>> forms, List<String> answer_with_repetition, String temp, int form_number) {
        for (int adjacent_form_number = form_number + 1; adjacent_form_number < forms.size(); adjacent_form_number++){
            if (forms.get(adjacent_form_number).get(1).contains(temp)) {
                answer_with_repetition.add(forms.get(adjacent_form_number).get(0));
                answer_with_repetition.add(forms.get(form_number).get(0));
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> answer_with_repetition = new ArrayList<>();

        if (!check_exceptions(forms))
            return (List.of(""));
        answer_with_repetition = find_answer(forms);
        for (String email : answer_with_repetition){
            if(!answer.contains(email))
                answer.add(email);
        }
        Collections.sort(answer);
        return answer;
    }
}

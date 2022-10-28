package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    /**
     * 기능 목록
     * 1. 닉네임 2글자로 자르기
     * 2. 자른 2글자로 중복 확인
     */

    /**
     * 1. 닉네임 2글자로 자르기
     * @param name: 닉네임
     * @return : 주어진 닉네임을 2글자씩 자른 string list
     */
    static List<String> split(String name){
        List<String> twoWord = new ArrayList<>();
        for (int i = 0; i < name.length() - 1; i++){
            twoWord.add(name.substring(i, i+2));
        }
        return twoWord;
    }

    /**
     * 2. 잘린 2글자 닉네임으로 중복 확인
     * @param twoWord : 주어진 닉네임 2글자씩 자른 string list
     * @param subForms : 비교할 닉네임, 이메일 담긴 Forms
     * @return : 중복된 닉네임의 이메일
     */
    static List<String> findDuplicate(List<String> twoWord, List<List<String>> subForms){
        List<String> email = new ArrayList<>();

        for (String s : twoWord) {
            for (List<String> subForm : subForms) {
                String cmpEmail = subForm.get(0);
                String cmpName = subForm.get(1);
                if (cmpName.contains(s)) email.add(cmpEmail);
            }
        }

        return email;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

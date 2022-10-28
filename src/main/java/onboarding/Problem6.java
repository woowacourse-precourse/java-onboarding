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

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

package onboarding;

//기능1. 닉네임과 닉네임을 두글자씩 검사한다.
//기능2. 겹치는 닉네임글자가 있으면 이메일만 리스트에 추가한다.
//기능3. 기능1,2 를 2중포문으로 만들어 모든 닉네임끼리 비교하게 한다.
//기능4 . answer 을 오름차순으로 정렬한뒤 리턴한다.

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        System.out.println(forms);
        System.out.println(forms.get(0));
        System.out.println((forms.get(0)).get(0));

        String a = (forms.get(0)).get(1); //제이엠
        String b = (forms.get(1)).get(1); //제이슨

        if ((a.charAt(0) == b.charAt(0)) && (a.charAt(1) == a.charAt(1))) {
            answer.add((forms.get(0)).get(0));
        }
        System.out.println(answer);


        return answer;
    }
}

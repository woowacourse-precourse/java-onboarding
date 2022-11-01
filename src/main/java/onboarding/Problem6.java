package onboarding;

//기능1. 비교할 닉네임의 두글자를 문자열에 저장한다. ex)"제이엠" 에서 "제이"만 저장
//기능2. 겹치는 닉네임글자가 있으면 이메일만 리스트에 추가한다. ex)"제이" 가 다른 닉네임에 포함되는지 검사
//기능3. 문자열을 초기화 하고 비교할 닉네임의 다음 두 글자를 문자열에 저장한뒤 기능2 실행. ex)"제이엠" 에서 "이엠" 만 저장
//기능4. 반복문을 통해 모든 닉네임을 비교한다.
//기능5. answer 을 오름차순으로 정렬한뒤 리턴한다.

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        String str = "";
        System.out.println(forms);
        System.out.println(forms.get(0));
        System.out.println((forms.get(0)).get(0));

        String a = (forms.get(0)).get(1); //제이엠
        String b = (forms.get(1)).get(1); //제이슨
        String c = (forms.get(2)).get(1); //워니
        String d = (forms.get(3)).get(1); //엠제이
        String e = (forms.get(4)).get(1); //이제엠

        str = str.concat(String.valueOf(a.charAt(0)));
        str = str.concat(String.valueOf(a.charAt(1)));

        System.out.println(str);

        return answer;
    }
}

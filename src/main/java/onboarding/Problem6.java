package onboarding;

//기능1. 비교할 닉네임의 두글자를 문자열에 저장한다. ex)"제이엠" 에서 "제이"만 저장
//기능2. 겹치는 닉네임글자가 있으면 이메일만 리스트에 추가한다. ex)"제이" 가 다른 닉네임에 포함되는지 검사
//기능3. 문자열을 초기화 하고 비교할 닉네임의 다음 두 글자를 문자열에 저장한뒤 기능2 실행. ex)"제이엠" 에서 "이엠" 만 저장
//기능4. 반복문을 통해 모든 닉네임을 비교한다.
//기능5. answer 을 오름차순으로 정렬한뒤 리턴한다.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String cp = "";
        String name = "";

        for (int k=0;k<forms.size();k++) {
            name = (forms.get(k)).get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                cp = "";
                cp = cp.concat(String.valueOf(name.charAt(i)));
                cp = cp.concat(String.valueOf(name.charAt(i + 1)));
                for (int j = k+1; j < forms.size(); j++) {
                    if ((forms.get(j)).get(1).contains(cp)) {
                        answer.add(forms.get(j).get(0));
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }

        Set<String> set = new HashSet<String>(answer);
        List<String> an =new ArrayList<String>(set);

        return an;
    }
}

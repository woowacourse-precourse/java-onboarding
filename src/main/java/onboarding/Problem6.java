package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // isDuplicated: 중복된 문자열이 있는지 확인하는 변수
        boolean isDuplicated;
        // myName: 나를 기준으로 반복문을 수행할 때 나의 이름
        // curName: 나를 기준으로 반복문을 수행할 때 상대의 이름
        // mySubName: myName에서 잘라낸 이번 비교에 사용할 문자열
        String myName, curName, mySubName;
        // form: 나의 정보
        // cur: 상대의 정보
        List<String> form, cur;
        // answerSet: 결과를 정렬해서 저장하기 위한 TreeSet
        SortedSet<String> answerSet;

        answerSet = new TreeSet<>();
        for(int i = 0; i < forms.size(); i++) {
            // 나의 정보를 저장
            form = forms.get(i);
            myName = form.get(1);

            for(int j = i + 1; j < forms.size(); j++) {
                isDuplicated = false;
                // 상대의 정보를 저장
                cur = forms.get(j);
                curName = cur.get(1);

                for(int k = 0; k < myName.length() - 1; k++) {
                    // 나의 이름에서 순서대로 2글자를 잘라냄
                    mySubName = myName.substring(k, k + 2);

                    // 잘라낸 문자열이 상대의 이름에 있으면 중복이 발생했음을 체크
                    if(curName.contains(mySubName)) {
                        isDuplicated = true;
                        break;
                    }
                }
                // 중복이 발생했다면 결과 set에 추가
                if(isDuplicated) {
                    answerSet.add(form.get(0));
                    answerSet.add(cur.get(0));
                }
            }
        }
        answer = new ArrayList<>(answerSet);

        return answer;
    }
}

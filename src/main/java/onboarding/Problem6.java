package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++) {
            list.add(forms.get(i).get(1));
        }
        String name = list.get(0);
        answer.add(forms.get(0).get(0));
        for(int i = 1; i < list.size(); i++) {
            int check = 0;
            int k = 0;                      // k 값으로 각 이름들의 자리 순서대로 같은 값을 찾음
            for(int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                while(k < list.get(i).length()) {
                    if(c == list.get(i).charAt(k) && c > 1) {       // 연속되서 같은 값이 있는 경우
                        check++;k++;
                        break;}
                    else if(c == list.get(i).charAt(k)) {           // 연속되지 않고 같은 값이 있는 경우
                        check = 1;
                        k++;
                        break;}
                    k++;
                }
            }
            if(check >= 2) 
                answer.add(forms.get(i).get(0));
        }

        Collections.sort(answer);           // 오름차순 정렬
        return answer;
    }
}

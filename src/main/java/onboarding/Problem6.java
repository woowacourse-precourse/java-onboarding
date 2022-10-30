package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> ans = new HashSet<>();
        HashMap<String,ArrayList<String>> s = new HashMap<>();

        for (int i=0; i<forms.size(); i++) {
            boolean flag = false;
            for (int t=0; t<=forms.get(i).get(1).length()-2; t++) {         //문자열을 길이 2씩 나눈다
                if (s.containsKey(forms.get(i).get(1).substring(t,t+2))) {  //이미 있는 길이2의 문자열이라면
                    s.get(forms.get(i).get(1).substring(t,t+2)).add(forms.get(i).get(0));   //중복됨으로 해당 중복되는 list에 추가
                } else {
                    ArrayList<String> tmp = new ArrayList<>();              //그렇지 않다면 새로운 키 값 생성
                    tmp.add(forms.get(i).get(0));
                    s.put(forms.get(i).get(1).substring(t,t+2),tmp);
                }
            }
        }
        for (String key : s.keySet()) { //keySet중 길이가 2이상인 중복된 문자열을 answer에 삽입
            if (s.get(key).size()>1) {
                for (int i = 0; i < s.get(key).size(); i++) {
                    ans.add(s.get(key).get(i));
                }
            }
        }
        List<String> answer = new ArrayList<>(ans);
        Collections.sort(answer);   //정렬 후 반환
        return answer;
    }
}

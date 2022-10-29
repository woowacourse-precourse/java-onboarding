package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    /*
    * 기능 목록 구현
    * 1. 같은 글자가 연속적으로 포함되는 최소케이스인 길이가 2인것에 대해, 각 닉네임을 2씩 slicing하여 map에 저장하는 기능.
    * 2. 다시 닉네임을 순회하며, nickname slicing을 했을때, map에 저장된 value가 2이상인 경우, answer에 추가하는 기능.
    * 3. 글자가 연속적으로 중복되는 이메일을 오름차순으로 정렬하는 기능.
    * 시간 복잡도 = O(19*N) = O(N)
    * */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();

        for (List<String> form : forms){
            for(int i=0;i<form.get(1).length()-1;i++){
                if (map.containsKey(form.get(1).substring(i,i+2))){
                    map.put(form.get(1).substring(i,i+2),map.get(form.get(1).substring(i,i+2))+1);
                }
                else {
                    map.put(form.get(1).substring(i, i + 2), 1);
                }
            }
        }

        for (List<String> form : forms){
            for (int i=0;i<form.get(1).length()-1;i++){
                if (map.get(form.get(1).substring(i,i+2))>1){
                    answer.add(form.get(0));
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}

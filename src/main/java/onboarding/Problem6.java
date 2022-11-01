package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 1. 같은 글자가 연속적으로 포함된 이메일을 구한다.
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int N = forms.size();
        for (int i = 0; i < N; i++){
            String nick = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            int M = nick.length();
            for (int j = 0; j < M-1; j++){
                String key = nick.substring(j, j+2);
                ArrayList<String> valueList = new ArrayList<String>();
                if (map.containsKey(key)) {
                    valueList = map.get(key);
                }
                valueList.add(email);
                map.put(key, valueList);
            }
        }
        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);
            if(list.size() >= 2){
                for(String email: list){
                    answer.add(email);
                }
            }
        }
        return answer;
    }
}

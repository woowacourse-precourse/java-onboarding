package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> dict = new HashMap<>();
        List<String> answer = new ArrayList<>();

        // HashMap 세팅
        for (List<String> form : forms) {
            String name = form.get(1);
            if (name.length() > 1) {
                for (int i=0; i < name.length()-1; i++) {
                    String sub_name = name.substring(i, i+2);
                    if (dict.containsKey(sub_name)) {
                        int prev = dict.get(sub_name);
                        dict.replace(sub_name, prev+1);
                    } else {
                        dict.put(sub_name, 1);
                    }
                }
            }
        }

        // 유사 닉네임 탐색
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            if (name.length() > 1) {
                for (int i=0; i < name.length()-1; i++) {
                    String sub_name = name.substring(i, i+2);
                    if (dict.get(sub_name) > 1) {
                        answer.add(email);
                        break;
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

}
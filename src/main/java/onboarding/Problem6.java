package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, Integer> duplicate = new HashMap<String, Integer>();
        for(List userList: forms) {
            String nickname = userList.get(1).toString();
            for(int i = 0; i < nickname.length() - 1; i++){
                String subString = nickname.substring(i, i + 2);
                if(duplicate.containsKey(subString)) {
                    duplicate.put(subString, duplicate.get(subString) + 1);
                }
                if(!duplicate.containsKey(subString)) {
                    duplicate.put(subString, 1);
                }
            }
        }
        for(List userList: forms) {
            String nickname = userList.get(1).toString();
            String email = userList.get(0).toString();
            for(int i = 0; i < nickname.length() - 1; i++){
                String subString = nickname.substring(i, i + 2);
                if(duplicate.get(subString) >= 2) {
                    answer.add(email);
                    break;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}

package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Hashtable<String, String> existDict = new Hashtable<String, String>();
        HashSet<String> existSet = new HashSet<String>();

        for (List<String> form: forms){
            String email = form.get(0);
            String nickname = form.get(1);

            if (email.length() < 11 || email.length() >= 20)    //email 길이 제한
                break;
            if (!Pattern.matches("\\S+@email.com", email))  //email 형식 제한
                break;
            if (nickname.length() < 1 || nickname.length() >= 20)   //nickname 길이 제한
                break;

            for (int i=0; i<nickname.length()-1; i++){
                String key = nickname.substring(i, i+2);    //2글자 단위로 key 설정
                if (existDict.containsKey(key)){    //이미 key가 있다면
                    existSet.add(email);
                    existSet.add(existDict.get(key));
                }
                existDict.put(key, email);
            }
        }
        List<String> answer = new ArrayList<String>(existSet);
        Collections.sort(answer);
        return answer;
    }
}

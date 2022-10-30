package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Hashtable<String, String> existDict = new Hashtable<String, String>();
        HashSet<String> existSet = new HashSet<String>();

        for (int i=0 ;i<forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (email.length() < 11 || email.length() >= 20)
                break;
            if (!Pattern.matches("\\S+@email.com", email))
                break;
            if (nickname.length() < 1 || nickname.length() >= 20)
                break;

            for (int j=0; j<nickname.length()-1; j++){
                String key = nickname.substring(j, j+2);
                if (existDict.containsKey(key)){
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

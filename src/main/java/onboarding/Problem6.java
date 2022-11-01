package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }
    private static boolean isContainSameStr(String a, String b){
        boolean result = false;
        HashMap<String, Boolean> aMap = new HashMap<String, Boolean>();

        for (int i=0; i<a.length()-1;i++){
            String temp = a.substring(i, i+2);
            aMap.put(temp, true);
        }
        for (int i=0;i<b.length();i++){
            String temp = b.substring(i, i+2);
            if (aMap.containsKey(temp)){
                result =true;
                break;
            }
        }
        return result;
    }
}

package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(makeRedunSet(forms));
        Collections.sort(answer);
        return answer;
    }
    private static boolean EmailVaildCheck(String input){
        return input.contains("@email.com");
    }
    private static boolean redunCheck(String first, String second){
        boolean result = false;
        if(first.length() > 2)
            for(int i = 0; i < first.length()-1; i++){
                result = second.contains(first.substring(i, i+2));
                if(result)
                    break;
            }
        else {
            result = first.equals(second);
        }
        return result;
    }
    private static Set<String> makeRedunSet(List<List<String>> input){
        Set<String> result = new HashSet<>();
        for(int i = 0; i < input.size(); i++){
            String standEmail = input.get(i).get(0);
            String standNickName = input.get(i).get(1);
            if(!EmailVaildCheck(standEmail))
                continue;
            for(int j = i + 1; j < input.size(); j++){
                String diffEmail = input.get(j).get(0);
                String diffNickName = input.get(j).get(1);
                if(!EmailVaildCheck(diffEmail))
                    continue;
                if(redunCheck(standNickName, diffNickName)) {
                    if(!result.contains(standEmail))
                        result.add(standEmail);
                    if(!result.contains(diffEmail))
                        result.add(diffEmail);
                }
            }
        }
        return result;
    }
}

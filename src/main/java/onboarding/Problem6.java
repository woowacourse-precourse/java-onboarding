package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    private static Map<String, List<Integer>> map = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean detectError(List<List<String>> forms){
        for(List<String> l: forms){
            if(l.get(0).length()<11||l.get(0).length()>=20)
                return false;
            if(l.get(1).length()>=20)
                return false;

            String email = l.get(0);
            if(!email.substring(email.length()-10,email.length()).equals("@email.com"))
                return false;
        }

        return true;
    }

    private static void convertList2TwoCharCount(String str, int idx){

    }

    private static Set<Integer> getAnswerIndex(){

    }
}

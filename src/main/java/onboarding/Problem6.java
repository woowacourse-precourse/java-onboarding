package onboarding;

import java.util.*;

public class Problem6 {

    private static Map<String, HashSet<Integer>> twoCharCnt = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean detectError(List<List<String>> forms){
        for(List<String> l: forms){
            if(l.get(0).length()<11||l.get(0).length()>=20)
                return true;
            if(l.get(1).length()>=20)
                return true;

            String email = l.get(0);
            if(!email.substring(email.length()-10,email.length()).equals("@email.com"))
                return true;
        }

        return false;
    }

    private static void convertList2TwoCharCount(String str, int idx){
        for(int i=0;i<str.length() - 1;i++){
            String twoChar = str.substring(i,i+2);

            twoCharCnt.get(twoChar).add(idx);
        }
    }

    private static Set<Integer> getAnswerIndex(){
        Set<Integer> ret = new HashSet<>();

        for(String key: twoCharCnt.keySet()){
            Set<Integer> list = twoCharCnt.get(key);

            if(list.size()>1){
                ret.addAll(list);
            }
        }

        return ret;
    }
}

package onboarding;

import java.util.*;

public class Problem6 {

    //<twoChar, 처음으로 twoChar를 가진 크루 index> 저장
    private static Map<String, Integer> twoChar = new HashMap<>();

    //answer에 포함되는 크루 idx 저장
    private static Set<Integer> duplicatedAnswer = new HashSet<>();

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

    private static void isDuplicateOtherNickname(List<String> form, int idx){

    }

    private static void storeTwoChar(String str, int idx){
        if(!twoChar.containsKey(str)){
            twoChar.put(str, idx);
        }
    }
}

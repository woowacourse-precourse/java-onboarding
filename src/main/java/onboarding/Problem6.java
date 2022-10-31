package onboarding;

import java.util.*;

public class Problem6 {

    //<twoChar, 처음으로 twoChar를 가진 email>
    private static Map<String, String> twoChar = new HashMap<>();

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

    private static boolean isDuplicateOtherNickname(List<String> form){

    }

    private static void storeTwoChar(String twoChar){

    }
}

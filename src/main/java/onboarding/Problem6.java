package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static boolean checkOverlap(String nicknameA, String nicknameB) {
        for(int i=0 ; i<nicknameA.length()-1 ; i++) {
            for(int j=0 ; j<nicknameB.length()-1 ; j++) {
                if(nicknameA.charAt(i) == nicknameB.charAt(j)) {
                    if(nicknameA.charAt(i+1) == nicknameB.charAt(j+1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        boolean
        return answer;
    }
}

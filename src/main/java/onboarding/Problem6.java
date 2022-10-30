package onboarding;

import java.util.*;

public class Problem6 {


    public static boolean checkNicknameOverlap(String nicknameA, String nicknameB) {
        if(nicknameA.length() < 1 || nicknameA.length() > 19 || nicknameB.length() < 1 || nicknameB.length() > 19) {
            return false;
        }

        for(int i=0 ; i<nicknameA.length()-1 ; i++) {
            for(int j=0 ; j<nicknameB.length()-1 ; j++) {
                if(nicknameA.charAt(i) == nicknameB.charAt(j)) {
                    if(!checkHangeul(nicknameA.charAt(i))) {
                        return false;
                    }

                    if(!checkHangeul(nicknameB.charAt(i))) {
                        return false;
                    }

                    if(nicknameA.charAt(i+1) == nicknameB.charAt(j+1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean checkHangeul(char word) {
        if(String.valueOf(word).matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            return true;
        }
        return false;
    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        return answer;
    }
}
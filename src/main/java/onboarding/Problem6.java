package onboarding;

import java.util.*;

public class Problem6 {

    public static boolean validCheck(List<List<String>> list){
        if(list.size()< 1 || list.size() > 10000){
            return false;
        }
        for(List<String> user : list){
            if(user.get(0).length() < 11 || user.get(0).length() >= 20){
                return false;
            }
            if(!user.get(0).substring(user.get(0).length() - 9, user.get(0).length()).equals("email.com")){
                return false;
            }
            if(!isItKorean(user.get(1))){
                return false;
            }
            if(user.get(1).length() < 1 || user.get(1).length() >= 20){
                return false;
            }
        }
        return true;
    }

    private static boolean isItKorean(String s) {
        for(int i=0;i<s.length();i++){
            if(Character.getType(s.charAt(i)) != 5){
                return false;
            }
        }
        return true;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if (!validCheck(forms)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        return answer;
    }
}

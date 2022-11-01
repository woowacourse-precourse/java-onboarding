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
                    if(!isHangeul(nicknameA.charAt(i))) {
                        return false;
                    }

                    if(!isHangeul(nicknameB.charAt(i))) {
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

    public static boolean isHangeul(char word) {
        if(String.valueOf(word).matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            return true;
        }
        return false;
    }

    public static boolean checkEmailFormOverlap(List<String> answer, String Email) {
        int atIndex = Email.indexOf("@");
        if(!Email.substring(atIndex+1).equals("email.com")) {
            return false;
        }

        if(Email.length() <= 10 || Email.length() >=20) {
            return false;
        }

        if(answer.contains(Email)) {
            return false;
        }

        return true;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();
        boolean [] isNotNeedCheckApplicationList = new boolean[forms.size()];

        for(int i=0 ; i<forms.size()-1 ; i++) {
            if(isNotNeedCheckApplicationList[i]) continue;
            for(int j = i+1 ; j<forms.size() ; j++) {
                if(isNotNeedCheckApplicationList[j]) continue;
                if(checkNicknameOverlap(forms.get(i).get(1), forms.get(j).get(1))) {
                    isNotNeedCheckApplicationList[i] = true;
                    isNotNeedCheckApplicationList[j] = true;

                    if(checkEmailFormOverlap(answer, forms.get(i).get(0))) answer.add(forms.get(i).get(0));
                    if(checkEmailFormOverlap(answer, forms.get(j).get(0))) answer.add(forms.get(j).get(0));
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
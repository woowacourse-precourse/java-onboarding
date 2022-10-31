/*
 * 클래스명: Problem6
 *
 * 시작 날짜: 2022-10-30
 */

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> emailList = new ArrayList<>();
        IsOverlap isOverlap = new IsOverlap();
        IsValidNickName isValidNickName = new IsValidNickName();
        IsValidEmail isValidEmail = new IsValidEmail();

        int totalCrews = forms.size();
        for (int i=0; i<totalCrews-1; i++) {
            for (int j=i+1; j<totalCrews; j++) {
                String crew1 = forms.get(i).get(1);
                String crew2 = forms.get(j).get(1);

                if( ! isValidNickName.isValidNickName(crew1)){
                    continue;
                }
                if( ! isValidNickName.isValidNickName(crew2)) {
                    continue;
                }
                if (isOverlap.isOverlap(crew1, crew2)) {
                    emailList.add(forms.get(i).get(0));
                    emailList.add(forms.get(j).get(0));
                }
            }
        }

        Collections.sort(emailList);
        for(int i=0; i<emailList.size(); i++) {
            String email = emailList.get(i);
            if(isValidEmail.isValidEmail(email) && ! answer.contains(email)) {
                answer.add(email);
            }
        }

        return answer;
    }
}

class IsOverlap {
    public boolean isOverlap (String crew1, String crew2) {

        int crew1Length = crew1.length();
        int crew2Length = crew2.length();
        int[][] LCS = new int[crew1Length+1][crew2Length+1];
        char[] crew1Array = crew1.toCharArray();
        char[] crew2Array = crew2.toCharArray();

        for (int i=1; i<=crew1Length; i++) {
            for (int j=1; j<=crew2Length; j++) {
                if(crew1Array[i-1] == crew2Array[j-1] && LCS[i-1][j-1] >= 1) {// 두개 이상 중복이라면
                    return true;
                }
                if(crew1Array[i-1] == crew2Array[j-1]) {
                    LCS[i][j] = 1;
                }
            }
        }
        return false;
    }
}

class IsValidEmail {
    public boolean isValidEmail(String email) {
        int emailLength = email.length();
        if (emailLength < 11 || 20 <= emailLength) {
            return false;
        }

        String host = email.substring(emailLength-9);
        if( ! host.equals("email.com")) {
            return false;
        }
        return true;
    }
}

class IsValidNickName {
    public boolean isValidNickName(String nickName) {
        //한글만 제한할 기능을 넣을지 고민
        int nickNameLength = nickName.length();
        if(nickNameLength < 1 || 20 <= nickNameLength) {
            return false;
        }
        return true;

    }
}
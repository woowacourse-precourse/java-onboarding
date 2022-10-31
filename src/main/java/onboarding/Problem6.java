package onboarding;

import net.bytebuddy.TypeCache;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (CheckInput(forms)) {
        }throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(List<List<String>> forms){
        if(isInRange(forms)&&isEmail(forms)&&isNick(forms))return true;
        return false;
    }
    private static boolean isInRange(List<List<String>> forms){
        if(forms.size()>0 && forms.size()<10001) return true;
        return false;
    }
    private static boolean isEmail(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            String tmp = forms.get(i).get(0);
            if(tmp.indexOf("@email.com")==-1)return false;
        }
        return true;
    }
    private static boolean isNickInRange(String nickname){
        if(nickname.length() >0 && nickname.length() <21)return true;
        return false;
    }
    private static boolean isNickKorean(String nickname){
            for(int j=0; j<nickname.length(); j++){
                if(Character.getType(nickname.charAt(j))!=5) return false;
            } return true;
    }
    private static boolean isNick(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            String nickname = forms.get(i).get(1);
            if (isNickKorean(nickname) && isNickInRange(nickname))return true;
        }return false;
    }


}

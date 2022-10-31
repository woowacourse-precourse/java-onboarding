package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> overlapList = new HashSet<String>();

        for(int i=0; i<forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);

            //이메일, 닉네임 체크
            if(!(isEmail(email) || isNickName(nickName))) break;
            //중복 체크
            for(int j=forms.size()-1; j > 0; j--){
                String nickNameChk = forms.get(j).get(1);
                if(j==i) continue;
                if(overlapNickName(nickName, nickNameChk)) overlapList.add(email);
            }
        }

        List<String> overlapEmail = new ArrayList<>(overlapList);
        return overlapEmail;
    }

    public static boolean isEmail(String email){
        boolean validation = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);

        if(m.matches() &&  11 <= email.length() && email.length() < 20){
            if (email.split("@")[1].equals("email.com")) validation = true;
        }
        return validation;
    }

    public static boolean isNickName(String nickName){
        return Pattern.matches("^[가-힣]*$", nickName)
                && nickName.length() >= 1 && nickName.length() < 20;
    }

    public static boolean overlapNickName(String nickName, String nickNameChk){

        for(int i=0; i < nickName.length()-1; i++) {
            if (nickNameChk.contains(nickName.substring(i, i + 2))) return true;
        }
        return false;
    }
}

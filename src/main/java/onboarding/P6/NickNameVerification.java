package onboarding.P6;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class NickNameVerification {

    public static boolean nameverification(List<List<String>> forms){
        if(!NameKoreanCheck(forms) || !NameLengthCheck(forms)){
            return false;
        }
        return true;
    }
    private static List<String> NicknameList(List<List<String>> forms) {
        List<String> Nickname = new ArrayList<>();

        for (List<String> form : forms) {
            Nickname.add(form.get(1));

        }
        return Nickname;
    }
    private static boolean NameKoreanCheck(List<List<String>> name){
        String regex = "^[ㄱ-ㅎ가-힣]*$ ";
        for(String n : NicknameList(name)){
            if(!Pattern.matches(regex, n)){
                return false;
            }
        }
        return true;

    }
    private static boolean NameLengthCheck(List<List<String>> name) {
        for (String n : NicknameList(name)) {
            if (1 >= n.length() || n.length() >= 20) {
                return false;
            }

        }
        return true;
    }
}

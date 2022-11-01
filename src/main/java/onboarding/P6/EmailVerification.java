package onboarding.P6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailVerification {

    public static boolean emailverification(List<List<String>> forms){
        if(!EmailCheck(forms) || !DomainCheck(forms)){
            return false;
        }
        return true;
    }

    private static List<String> EmailList(List<List<String>> forms) {
        List<String> email = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            email.add(forms.get(i).get(0));

        }

        return email;
    }
    private static boolean EmailCheck(List<List<String>> email){
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

        for(String e : EmailList(email)){
            if(!Pattern.matches(regex, e)){
                return false;
            }
        }
        return true;
    }
    private static boolean DomainCheck(List<List<String>> email){
        String form = "@email.com";
        for(String e: EmailList(email)){
            if(form != e.substring(e.length()-10, e.length())){
                return false;
            }
        }
        return true;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return answer;
    }

    private static boolean isValidEmail(String email){
        if(email.length() < 11 || email.length() > 19)
            return false;
        String[] emailArr = email.split("@");
        String emailDomain = emailArr[1];
        if(!emailDomain.equals("email.com"))
            return false;

        return true;
    }

    private static boolean isValidNickname(String nickname){
        if(nickname.length() == 0 || nickname.length() > 19)
            return false;
        for(int i=0; i<nickname.length(); i++)
            if(!nickname.substring(i, i+1).matches("[가-힣]+"))
                return false;

        return true;
    }

    private static List<List<String>> trimInvalidFormat(List<List<String>> forms){
        List<List<String>> validFormat = new ArrayList<>();
        for(List<String> crew: forms)
            if(isValidEmail(crew.get(0)) && isValidNickname(crew.get(1)))
                validFormat.add(crew);

        return validFormat;
    }

}

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

}

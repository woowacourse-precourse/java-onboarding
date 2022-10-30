package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return new ArrayList<>();
    }


    // 이메일 형식체크
    public static boolean isValidEmail(String email) {
        if (email.isEmpty()) return false;  //null값인 경우(빈값)

        //방법 :정규식
        String regex = "^[a-z_0-9]{1,9}(@email.com)$";  //전체 길이 제한, 도메인 형식에 맞게
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) return true;
        return false;
    }
}
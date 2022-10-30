package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9]+(.[_A-Za-z0-9-]+)*@email[.]com");
        Pattern nicknamePattern = Pattern.compile("^[ㄱ-ㅎ가-힣]*");
        for (List<String> data : forms) {
            if(!emailPattern.matcher(data.get(0)).matches()) {
                System.out.println("올바르지 않은 이메일 형식입니다.");
                return null;
            }
            if(!nicknamePattern.matcher(data.get(1)).matches()) {
                System.out.println("닉네임은 한글만 가능합니다.");
                return null;
            }
        }
        return forms.get(0);
    }
}

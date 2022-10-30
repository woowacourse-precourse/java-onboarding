package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    // 추출한 두 글자 저장(두글자, 원본 이메일)
    static HashMap<String, String> twoSequence = new HashMap<>();
    // 이메일을 중복 추가 방지용 해시맵(email, boolean), true 면 이미 추가된 이메일
    static HashMap<String, Boolean> emailAlreadyAdded = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean isValidEmailDomain(String email){
        String[] emailArr = email.split("@");
        return Objects.equals(emailArr[emailArr.length - 1], "email.com");
    }
}

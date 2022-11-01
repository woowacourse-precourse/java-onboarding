package onboarding;

import java.util.List;

public class Problem6 {
    //  Static-Variable
    private static final String domain = "email.com";
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final int MIN_ID_LENGTH = 1;
    private static final int MAX_ID_LENGTH = 20;
    private static final String ID_PATTERN = "[ㄱ-ㅎㅏ-ㅣ가-힣]";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    //  회원 이름 유효성 검사
    private static Boolean verifyName(String name){
        if(!verifyNameLength(name)) return false;
        if(!verifyNameType(name)) return false;
        return true;
    }

    //  회원 이름 유효성 검사 - 길이
    private static Boolean verifyNameLength(String name){
        int length = name.length();
        if(length < MIN_ID_LENGTH) return false;
        if(length >= MAX_ID_LENGTH) return false;
        return true;
    }

    // 회원 이름 유효성 검사 - 소문자
    private static Boolean verifyNameType(String name){
        for(int i = 0; i < name.length(); i++){
            String targetChar = String.valueOf(name.charAt(i));
            if(!targetChar.matches(ID_PATTERN)) return false;
        }
        return true;
    }
}

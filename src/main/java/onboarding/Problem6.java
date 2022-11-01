package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    //  Static-Variable
    private static final String domain = "email.com";
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final int MIN_ID_LENGTH = 1;
    private static final int MAX_ID_LENGTH = 20;
    private static final String ID_PATTERN = "[ㄱ-ㅎㅏ-ㅣ가-힣]";

    public static List<String> solution(List<List<String>> forms) {
        //  Variable
        List<String> answer = new ArrayList<>();
        //  For-Loop : 입력된 회원 가입 정보의 유효성을 검사하는 반복문
        for(List<String> target : forms){
            if(verifyMemberList(target)) answer.add(target.get(0));
        }
        return answer.stream().sorted().collect(Collectors.toList());
    }

    //  입력된 회원 가입 정보 유효성 검사 - 이메일, 회원이름
    private static Boolean verifyMemberList(List<String> input){
        if(!verifyEmail(input.get(0))) return false;
        if(!verifyName(input.get(1))) return false;
        return true;
    }

    //  이메일 유효성 검사
    private static Boolean verifyEmail(String email){
        if(!verifyEmailLength(email)) return false;
        String[] splitEmail = email.split("@");
        if(!verifyEmailId(splitEmail[0])) return false;
        if(!verifyEmailDomain(splitEmail[1])) return false;
        return true;
    }

    //  이메일 유효성 검사 - 길이
    private static Boolean verifyEmailLength(String email){
        int length = email.length();
        if(length >= MAX_EMAIL_LENGTH)
            return false;
        if(length < MIN_EMAIL_LENGTH)
            return false;
        return true;
    }

    //  이메일 유효성 검사 - 도메인
    private static Boolean verifyEmailDomain(String emailDomain){
        if(emailDomain.equals(domain))
            return true;
        return false;
    }

    //  이메일 유효성 검사 - 아이디
    private static Boolean verifyEmailId(String emailId){
        for (int i = 0; i < emailId.length() - 1; i++) {
            int comp = (int) emailId.charAt(i + 1) - (int) emailId.charAt(i);
            if ( comp == 0 || comp == 1)  return false;
        }
        return true;
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

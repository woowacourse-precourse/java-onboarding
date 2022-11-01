package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

class Email {
    private static final String DOMAIN = "@email.com";
    private static final String DOMAIN_FORM_ERROR = "도메인 형식이 잘못되었습니다.";
    private String email;

    public Email(String email) {
        validateEmailForm(email);
        this.email = email;
    }

    private void validateEmailForm(String email) {
        if (!email.contains(DOMAIN)) {
            throw new IllegalStateException(DOMAIN_FORM_ERROR);
        }
    }
}

class NickName {
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
    }
    public Set<String> duplicatedCases() {
        Set<String> duplicatedCasesSet = new HashSet<>();

        for(int i=0;i<nickName.length()-2;i++){
            String nickNameSubString= nickName.substring(i,i+2);
            duplicatedCasesSet.add(nickNameSubString);
        }
        return duplicatedCasesSet;
    }
}

class Crew {
    private final Email email;
    private final NickName nickName;

    public Crew(Email email, NickName nickName) {
        this.email = email;
        this.nickName = nickName;
    }
}

class NickNameDuplicate {

}
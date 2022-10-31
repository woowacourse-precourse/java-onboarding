package onboarding.problem6;

import java.util.regex.Pattern;

public class Nickname {
    private String KOREAN_REGEX = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$"; // 한글을 처리할 때 자음과 모음을 따로 써줘야 하는구나.
    private String value;
    public Nickname(String input) {
        if(input.length()<1 || input.length()>=20) {
            System.out.println("닉네임의 길이는 1자 이상 20자 미만이어야 합니다");
        }
        if (!Pattern.matches(KOREAN_REGEX, input)) {
            System.out.println("닉네임은 한글로만 구성되어야 합니다");
        }
        this.value = input;
    }

    public String getValue() {
        return value;
    }
}

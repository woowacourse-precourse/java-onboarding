package onboarding.Prombem6;

import java.util.regex.Pattern;

public class Nickname {
    // "/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/"
    private String KOREAN_REGEX = "^[ㄱ-ㅎ가-힣]*$";
    private String value;
    public Nickname(String input) throws Exception {
        if(input.length()<1 || input.length()>=20) {
            throw new Exception("닉네임의 길이는 1자 이상 20자 미만이어야 합니다");
        }
        if (!Pattern.matches(KOREAN_REGEX, input)) {
            throw new Exception("닉네임은 한글로만 구성되어야 합니다");
        }
        this.value = input;
    }

    public String getValue() {
        return value;
    }
}

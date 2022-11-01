package onboarding.problem6;

import java.util.regex.Pattern;

public class Validator {

    // 입력된 닉네임과 이메일의 유효성 검증 기능
    public static void validate(String nickname, String email){
        nicknameValidate(nickname);
        emailValidate(email);
    }

    // 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만
    public static void nicknameValidate(String nickname) {

        if (!isNickNameKorean(nickname)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }

        if (nickname.length() < 1 || nickname.length() >= 20) {
            throw new IllegalArgumentException("닉네임은 1자 이상 20자 미만입니다.");
        }
    }

    // 이메일은 이메일 형식에 부합(email.com 도메인으로만 제한)하며, 전체 길이는 11자 이상 20자 미만
    public static void emailValidate(String email){

        if(!isEmail(email)){
            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
        }

        if (email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만입니다.");
        }
    }

    // 닉네임은 한글 여부 체크
    public static boolean isNickNameKorean(String nickname) {
        return Pattern.matches("^[ㄱ-ㅎ가-힣]*$", nickname);
    }

    // 이메일 형식 체크
    public static boolean isEmail(String email) {
        return Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com", email);
    }

}

package onboarding.Prombem6;

public class Email {
    public Email(String input) throws Exception {
        if(input.length()<11 || input.length()>=20) {
            throw new Exception("이메일의 길이는 11자 이상 20자 미만이어야 합니다");
        }
        if (!"@email.com".equals(input.substring(input.length() - 10))) {
            throw new Exception("이메일은 @email.com로 끝나야 합니다");
        }
    }
}

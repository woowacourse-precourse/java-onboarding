package onboarding.problem6;

public class Email {
    private String LOWER_ALPHABET_AND_NUMBER_REGEX = "^[a-z0-9]*$";
    private String value;
    public Email(String input) {
        if(input.length()<11 || input.length()>=20) {
            System.out.println("이메일의 길이는 11자 이상 20자 미만이어야 합니다");
        }
        if (!"@email.com".equals(input.substring(input.length() - 10))) {
            System.out.println("이메일은 @email.com로 끝나야 합니다");
        }
        String value = input.substring(0, input.length() - 10);
        if (!value.matches(LOWER_ALPHABET_AND_NUMBER_REGEX)) {
            System.out.println("이메일은 숫자와 영소문자로만 만들 수 있습니다");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Object format() {
        return value + "@email.com";
    }
}

package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NameStringClassForPro6 {
    private static String[] nameString;

    public NameStringClassForPro6(List<List<String>> forms) {
        ExceptionClassForPro6 exceptionClass = new ExceptionClassForPro6(forms);
        nameString = new String[forms.size()];
        fillNameString(forms);
    }

    private static void fillNameString(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> partOfForm = forms.get(i);
            nameString[i] = partOfForm.get(1);
        }
    }
}

class ExceptionClassForPro6 {

    private static final int MINIMUM_MEMBER = 1;
    private static final int MAXIMUM_MEMBER = 10000;
    private static final int EMAIL_LENGTH_MIN = 11;
    private static final int EMAIL_LENGTH_MAX = 20;

    public ExceptionClassForPro6(List<List<String>> forms) {
        validateArguments(forms);
    }

    private void validateArguments(List<List<String>> forms) {
        validateTotalMember(forms);
        for (List<String> userProfile : forms) {
            validateEmail(userProfile.get(0));
            validateEmailLength(userProfile.get(0));
        }
    }

    private void validateTotalMember(List<List<String>> forms) {
        if (forms.size() < MINIMUM_MEMBER || MAXIMUM_MEMBER < forms.size()) {
            throw new IllegalArgumentException(
                "총 인원 수는 " + MINIMUM_MEMBER + "이상 " + MAXIMUM_MEMBER + "이하의 정수여야 합니다.");
        }
    }

    private static void validateEmail(String email) {
        Pattern p = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
        if (!email.contains("@email.com")) {
            throw new IllegalArgumentException("이메일의 도메인은 반드시 @email.com이어야 합니다.");
        }
    }

    private static void validateEmailLength(String email) {
        if (email.length() < EMAIL_LENGTH_MIN || EMAIL_LENGTH_MAX <= email.length()) {
            throw new IllegalArgumentException(
                "이메일의 길이는 " + EMAIL_LENGTH_MIN + "이상 " + EMAIL_LENGTH_MAX + "미만의 정수여야 합니다.");
        }
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        NameStringClassForPro6 nameClass = new NameStringClassForPro6(forms);
        List<String> answer = List.of("answer");
        return answer;
    }
}

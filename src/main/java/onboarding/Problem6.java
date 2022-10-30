package onboarding;

import java.util.List;

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

    public ExceptionClassForPro6(List<List<String>> forms) {
        validateArguments(forms);
    }

    private void validateArguments(List<List<String>> forms) {
        validateTotalMember(forms);
    }

    private void validateTotalMember(List<List<String>> forms) {
        if (forms.size() < MINIMUM_MEMBER || MAXIMUM_MEMBER < forms.size()) {
            throw new IllegalArgumentException(
                "총 인원 수는 " + MINIMUM_MEMBER + "이상 " + MAXIMUM_MEMBER + "이하의 정수여야 합니다.");
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

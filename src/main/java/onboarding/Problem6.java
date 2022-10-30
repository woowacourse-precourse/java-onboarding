package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();

        return answer;
    }

    public static boolean throwCrewNumberException(List<List<String>> forms) {
        return (forms.isEmpty() || forms.size() > 10_000);
    }

    public static boolean throwEmailLengthException(List<String> forms) {
        return (forms.get(0).length() < 11 || forms.get(0).length() > 20);

    }

    public static boolean throwEmailTypeException(List<String> forms) {
        int index = forms.get(0).indexOf("@");

        return (forms.get(0).substring(index).equals("@email.com"));
    }

    public static boolean throwNameNotKoreanException(List<String> forms) {
        return (!forms.get(1).matches("^[ㄱ-ㅎ가-힣]*$"));
    }

    public static boolean throwNameLengthException(List<String> forms) {
        return (forms.get(1).length() < 1 || forms.get(1).length() >= 20);
    }


}

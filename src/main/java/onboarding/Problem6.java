package onboarding;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Problem6 {
    static final HashMap<String, String> hm = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static boolean validationCheck(List<List<String>> forms) {
        if (inputValidation(forms) && contentValidation(forms)) {
            return true;
        }
        return false;
    }
    public static boolean inputValidation(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            return false;
        }
        return true;
    }

    public static void splitLexim(List<String> repository, String name) {
        for (int j = 0; j < name.length()-1; j++) {
            repository.add(name.substring(j, j+2));
        }
    }

}

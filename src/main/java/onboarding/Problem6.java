package onboarding;

import java.util.List;

public class Problem6 {

    private static boolean isValidPersonal(int n) {
        return n >= 1 && n <= 10_000;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("");
        if(!isValidPersonal(forms.size())) return answer;



        return answer;
    }
}

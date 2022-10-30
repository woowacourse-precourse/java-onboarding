package onboarding;

import java.util.List;

public class Problem6 {

    private static boolean checkParam(List<List<String>> forms) {
        if (forms == null)
            return true;
        int size = forms.size();
        if (size == 0 || size > 10000)
            return true;
        for (int i=0; i<size; i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (checkEmail(email) || checkNickname(nickname))
                return true;
        }
        return false;
    }
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

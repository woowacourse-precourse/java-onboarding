package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return checkDuplicate(forms, answer);
    }

    // 자기 자신 빼고의 닉네임들을 문자열로 만드는 기능
    public static String nicknamesToString (List<String> names, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < names.size(); j++) {
            if (j != i)
                sb.append(names.get(j)).append(".");
        }
        return sb.toString();
    }
}

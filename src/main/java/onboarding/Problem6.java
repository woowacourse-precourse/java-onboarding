package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean hasDuplication(String name1, String name2) {
        int n1 = name1.length();
        int n2 = name2.length();

        for (int i = 0; i < n1 - 1; i++) {
            for (int j = 0; j < n2 - 1; j++) {
                if (findDuplication(name1, name2, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean findDuplication(String name1, String name2, int i, int j) {
        if (name1.charAt(i) == name2.charAt(j)) {
            return name1.charAt(i + 1) == name2.charAt(j + 1);
        }
        return false;
    }
}

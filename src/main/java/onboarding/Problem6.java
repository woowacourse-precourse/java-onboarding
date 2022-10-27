package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static class Member {
        private String name;
        private String email;

        public Member(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    private static boolean hasConsecutiveString(String base, String target) {

        int baseLength = base.length();
        int targetLength = target.length();

        for (int i = 0; i < baseLength - 1; i++) {
            for (int j = 0; j < targetLength - 1; j++) {
                if (base.charAt(i) == target.charAt(j)) {
                    if (base.charAt(i + 1) == target.charAt(j + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if(isLowerCase(now)){
                sb.append((char)('z'-(now-'a')));
                continue;
            }
            if(isUpperCase(now)){
                sb.append((char)('Z'-(now-'A')));
                continue;
            }
            sb.append(now);
        }
        return sb.toString();
    }

    private static boolean isLowerCase(char now) {
        return 'a' <= now && now <= 'z';
    }

    private static boolean isUpperCase(char now) {
        return 'A' <= now && now <= 'Z';
    }
}

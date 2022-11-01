package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if('a' <= now && now <= 'z'){
                sb.append((char)('z'-(now-'a')));
                continue;
            }
            if('A' <= now && now <= 'Z'){
                sb.append((char)('Z'-(now-'A')));
                continue;
            }
            sb.append(now);
        }
        return sb.toString();
    }
}

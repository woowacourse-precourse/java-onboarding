package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer sb = new StringBuffer();
        for (char c : word.toCharArray()) {
            if(!Character.isAlphabetic(c)){
                sb.append(c);
                continue;
            }
            if('A'<=c&&c<='Z')
                sb.append((char)('A'+'Z'-c));
            if('a'<=c&&c<='z')
                sb.append((char)('a'+'z'-c));
        }
        return sb.toString();
    }
}

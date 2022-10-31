package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        char[] upper = new char[26];
        char[] lower = new char[26];
        for (int i = 0; i < 26; i++) {
            upper[i] = (char)('Z' -i);
            lower[i]= (char)('z' -i);
        }
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)-'A'>=0 &&word.charAt(i)-'A'<=26){
                sb.append(upper[word.charAt(i)-'A']);
            }else if(word.charAt(i)-'a'>=0 &&word.charAt(i)-'a'<=26){
                sb.append(lower[word.charAt(i)-'a']);
            }else {
                sb.append(" ");
            }
        }
        return String.valueOf(sb);
    }
}

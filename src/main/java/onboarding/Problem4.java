package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] ch = word.toCharArray();
        for (int i = 0 ; i < ch.length ; i++){
            ch[i] = applyFrog(ch[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static char applyFrog(char ch){
        if (ch>='a' && ch<='z') return (char) ('a' + Math.abs(ch-'z'));
        if (ch>='A' && ch<='Z') return (char) ('A' + Math.abs(ch-'Z'));
        return ch;
    }
}

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<word.length();i++) {
            int c = word.charAt(i);
            if(c>=65 && c<=90) {
                c = 155 - c;
            } else if(c>=97 && c<=122) {
                c = 219 - c;
            }
            sb.append((char)c);
        }
        return sb.toString();
    }
}

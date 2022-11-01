package onboarding;

public class Problem4 {
    private static StringBuilder sb=new StringBuilder();
    private static String x="";
    public static String solution(String word) {
        String answer = "";
        return reverseString(word);
    }

    public static String reverseString(String string) {
        if(!error(string)) {
            for (int i = 0; i < string.length(); i++) {
                sb = (string.charAt(i) < 91 && string.charAt(i) >64) ? sb.append((char) ('A' + 'Z' - string.charAt(i))) :
                        ((string.charAt(i)<123 && string.charAt(i)>96)? sb.append((char) ('a' + 'z' - string.charAt(i))) : sb.append(string.charAt(i)));
            }
        }
        return BuildertoString(sb);
    }
}

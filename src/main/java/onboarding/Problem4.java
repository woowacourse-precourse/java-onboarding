package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();
        char b = 219;
        char d = 155;
        for (int i =0;i<word.length();i++) {
            char new_ch;
            if (chars[i]>=65&&chars[i]<=90) {
                new_ch = (char)(d-chars[i]);
                chars[i] = new_ch;
            }
            else if (chars[i]>=97&&chars[i]<=122){
                new_ch = (char)(b-chars[i]);
                chars[i] = new_ch;
            }
        }
        return new String(chars);
    }
}

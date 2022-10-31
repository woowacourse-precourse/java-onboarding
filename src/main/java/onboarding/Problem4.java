package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = translation(word);
        return answer;
    }

    public static String translation(String str) {
        int lenstr = str.length();
        String temp = "";
        for (int i=0;i<lenstr;++i)
            temp = temp + (char)wordBox(str.charAt(i));
        return temp;
    }

    public static int wordBox(char c) {
        String lowerstr = "abcdefghijklmnopqrstuvwxyz";
        String upperstr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0;i<26;++i) {
            if (c == lowerstr.charAt(i))
                return 'z' - i;
            else if (c == upperstr.charAt(i))
                return 'Z' - i;
        }
        return c;
    }
}

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        while (!cryptogram.equals(checkerString(cryptogram))) {
            cryptogram = checkerString(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }

    public static String checkerString(String str) {
        int len = str.length();
        int i = 0;
        String temp = "";
        for (i=0;i<len-1;++i) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                temp = temp + str.charAt(i);
            }
            else
                i += 1;
        }
        if (temp.length() > 0)
            temp = temp + str.charAt(i);
        return temp;
    }
}
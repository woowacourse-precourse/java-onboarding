package onboarding;

public class Problem2 {
    public static Boolean notSequence(char first, char last) {
        if (first != last) return true;
        return false;
    }
    public static String deleteDuplicate(String str, int num) {
        return str.substring(0, num - 1) + str.substring(num + 1);
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        String txt = cryptogram;

        for (int i = 1; i < txt.length(); i++) {
            if (notSequence(txt.charAt(i - 1), txt.charAt(i))) continue;
            txt = deleteDuplicate(txt, i);
            i = i - 2;
        }
        answer = txt;

        return answer;
    }
}

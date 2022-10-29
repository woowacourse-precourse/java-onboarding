package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String txt = cryptogram;

        for (int i = 1; i < txt.length(); i++) {
            if(txt.charAt(i - 1) != txt.charAt(i)) continue;

            txt = txt.substring(0, i - 1) + txt.substring(i + 1);
            i = i - 2;
            System.out.println(txt);
        }

        answer = txt;

        return answer;
    }
}

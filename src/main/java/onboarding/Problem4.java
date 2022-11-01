package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            int num = (int) ch;

            if (num == 32) {
               answer += " "; 
            }

            if (64 < num && num < 91) {
                int chaNum = 155 - num;
                char cha = (char) chaNum;
                String str = String.valueOf(cha);
                answer += str;
            }

            if (96 < num && num < 123) {
                int chaNum = 219 - num;
                char cha = (char) chaNum;
                String str = String.valueOf(cha);
                answer += str;
            }

        }
        return answer;
    }
}

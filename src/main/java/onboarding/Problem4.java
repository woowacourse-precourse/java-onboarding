package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String b = "";

        for (int i=0;i<word.length();i++) {
            if((int)word.charAt(i)==32) {
                b+=(char)32;
            }

            for (int j = 0; j < 26; j++) {
                if ((int)word.charAt(i)==65+j) {
                    b+=(char)(90-j);
                } else if ((int)word.charAt(i)==97+j) {
                    b+=(char)(122-j);
                }

            }
        }
        answer = b;
        return answer;
    }
}

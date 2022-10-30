package onboarding;

public class Problem4 {
    public static char translateAlpa(char alpa) {
        int ascnum = (int)alpa;
        // A ~ Z => 65 ~ 90
        // a ~ z => 97 ~ 122

        if(ascnum >= 65 && ascnum <= 90) {
            int gap = 90 - ascnum;
            char translatedChar = (char)(65 + gap);
            return translatedChar;
        }

        if(ascnum >= 97 && ascnum <= 122) {
            int gap = 122 - ascnum;
            char translatedChar = (char)(97 + gap);
            return translatedChar;
        }
    }


    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

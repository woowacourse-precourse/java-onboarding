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

        return alpa;
    }

    public static boolean checkInput(String word) {
        if(word.length() < 1 || word.length() > 1000) {
            return false;
        }

        return true;
    }

    public static String solution(String word) {
        if(!checkInput(word)) {
            return "";
        }

        String answer = "";
        for(int i=0 ; i<word.length() ; i++) {
            answer = answer + translateAlpa(word.charAt(i));
        }

        return answer;
    }
}

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordtemp = word.toCharArray();
        int reverse, abstemp, ascii = 0;

        for (int i = 0; i < wordtemp.length; i++) {
            if (Character.isUpperCase(wordtemp[i])) {
                ascii = 65;
            } else if (Character.isLowerCase(wordtemp[i])) {
                ascii = 97;

            } else {
                answer = answer + ' ';
                continue;
            }
            abstemp = Math.abs(ascii - wordtemp[i]);
            reverse = (ascii + 25) - abstemp;
            answer = answer + String.valueOf((char) reverse);


        }
        return answer;
    }


}
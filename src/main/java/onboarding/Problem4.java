package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordstrip = word.toCharArray();
        int reverse, abstemp, ascii = 0;
        for (int i = 0; i<wordstrip.length; i++) {
            if(Character.isUpperCase(wordstrip[i])) {
                ascii = 65;
            } else if (Character.isLowerCase(wordstrip[i])) {
                ascii = 97;
            } else {
                answer = answer + ' ';
                continue;
            }
            abstemp = Math.abs(ascii - wordstrip[i]);
            reverse = (ascii + 25) - abstemp;
            answer = answer + String.valueOf((char) reverse);
        }
        return answer;
    }
}

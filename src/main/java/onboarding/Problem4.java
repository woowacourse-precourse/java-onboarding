package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int numASumZ = 'A' + 'Z';
        int numaSumz = 'a' + 'z';
        int numSpace = ' ';

        for(int i = 0; i < word.length(); i++) {
            String setLetter = "";
            if('A' <= word.charAt(i) && word.charAt(i) <= 'Z')
                setLetter = String.valueOf((char)(numASumZ - word.charAt(i)));
            else if('a' <= word.charAt(i) && word.charAt(i) <= 'z')
                setLetter = String.valueOf((char)(numaSumz - word.charAt(i)));
            else if(word.charAt(i) == numSpace)
                setLetter = " ";
            answer += setLetter;
        }
        return answer;
    }
}

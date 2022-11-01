package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        ReverseAlphabet(word);
        return ReverseAlphabet(word);
    }

    private static String ReverseAlphabet(String word){
        String result = "";
        char [] wordArray = word.toCharArray();
        int reverse, absTemp, asciiCode = 0;
        for (int i = 0; i < wordArray.length; i++){
            if (Character.isUpperCase(wordArray[i])) { //대문자
                asciiCode = 65;
            } else if (Character.isLowerCase(wordArray[i])) { //소문자
                asciiCode = 97;
            } else {
                result = result + ' ';
                continue;
            }
            absTemp = Math.abs(asciiCode - wordArray[i]);
            reverse = (asciiCode + 25) - absTemp;
            result = result + String.valueOf((char) reverse);
        }
        return result;
    }
}
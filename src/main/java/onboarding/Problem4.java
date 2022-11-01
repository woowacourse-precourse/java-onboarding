package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<word.length();i++){
            int asciiWord = word.charAt(i);
            getAnswer(word, answer, i, asciiWord);
        }
        return answer.toString();
    }
    private static void getAnswer(String word, StringBuilder answer, int i, int asciiWord) {
        if (((65 <= asciiWord)&&(asciiWord <= 90))||((97 <= asciiWord) && (asciiWord <= 122))){
            getAlphabetAnswer(answer, asciiWord);
        }
        //알파벳 아닌 경우
        else{
            answer.append(word.charAt(i));
        }
    }
    private static void getAlphabetAnswer(StringBuilder answer, int asciiWord) {
        if(asciiWord <= 90){
            asciiWord = 155 - asciiWord;
        }
        else {
            asciiWord = 219 - asciiWord;
        }
        char ch = (char) asciiWord;
        answer.append(ch);
    }
}

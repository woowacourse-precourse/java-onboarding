package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] wordArray = word.toCharArray();

        for(int i = 0; i < word.length(); i++){
            byte asciiCode =  (byte)wordArray[i];
            if(asciiCode >= 65 && asciiCode <= 90){
                answer.append(convertBigLetter(wordArray[i]));
            }else if(asciiCode >= 97 && asciiCode <= 122){
                answer.append(convertSmallLetter(wordArray[i]));
            }else{
                answer.append(wordArray[i]);
            }
        }
        return answer.toString();
    }
    static char convertBigLetter(char c){
        int convertAscii = 90 - ((byte)c - 65);
        return (char)convertAscii;
    }
    static char convertSmallLetter(char c){
        int convertAscii = 122 - ((byte)c - 97);
        return (char)convertAscii;
    }
}

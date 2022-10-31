package onboarding;

public class Problem4 {
    static char convertReverse(char character){
        int ascii = (int)character;
        int startPoint = 0;
        int endPoint = 0;
        int displacement;
        int reverseAscii;

        if(65 <= ascii && ascii <= 90){
            startPoint = 65;
            endPoint = 90;
        }
        if(97<= ascii && ascii <= 122){
            startPoint = 97;
            endPoint = 122;
        }
        if(ascii == 32){
            return (char)ascii;
        }
        displacement = ascii - startPoint;
        reverseAscii = endPoint - displacement;
        return (char)reverseAscii;
    }
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            answer = answer.concat(String.valueOf(convertReverse(word.charAt(i))));
        }
        return answer;
    }
}

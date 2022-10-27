package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char charEncoder(char letter){
        char encodedletter = letter;
        int asciiIndex = letter;
        if(asciiIndex >= 'a' && asciiIndex <= 'z'){
            encodedletter = (char) (Math.abs(25-(asciiIndex - 'a')) + 'a');
        }
        if(asciiIndex >= 'A' && asciiIndex <= 'Z'){
            encodedletter =  (char) (Math.abs(25-(asciiIndex - 'A'))+'A');
        }


        return encodedletter;

    }
}

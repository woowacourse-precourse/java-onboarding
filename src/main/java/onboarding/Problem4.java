package onboarding;

public class Problem4 {
    public static char convertAlphabet(char originalAlphabet){
        int originalAsciiCode=(int) originalAlphabet;
        int convertedAsciiCode=0;
        int sumOfAsciiCodeInUpperCase=(int) 'A'+(int) 'Z';
        int sumOfAsciiCodeInLowerCase=(int) 'a'+(int) 'z';

        if((int) 'Z' >= originalAsciiCode){ // 대문자일 경우
            convertedAsciiCode=sumOfAsciiCodeInUpperCase-originalAsciiCode;
        } else if((int) 'a' <= originalAsciiCode){ // 소문자일 경우
            convertedAsciiCode=sumOfAsciiCodeInLowerCase-originalAsciiCode;
        }
        return (char)convertedAsciiCode;
    }
    public static String convertOriginalWord(String originalWord){
        String convertedWord="";
        for(int wordIndex=0;wordIndex<originalWord.length();wordIndex++){
            if(originalWord.charAt(wordIndex)==' ') { // 공백일 경우
                convertedWord+=" ";
            } else{
                convertedWord+=convertAlphabet(originalWord.charAt(wordIndex));
            }
        }
        return convertedWord;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

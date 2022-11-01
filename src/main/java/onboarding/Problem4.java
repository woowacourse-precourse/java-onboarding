package onboarding;

import onboarding.newExceptions.InvalidRestrictionException;

public class Problem4 {
    public static String solution(String word) {
        Problem4 restrictions = new Problem4();
        if(restrictions.isViolatedRestrictions(word)){
            throw new InvalidRestrictionException("word 의 길이가 1 이상 1,000 이하의 문자열이 아닙니다.");
        }

        StringBuilder answer = new StringBuilder();
        char[] wordArray = word.toCharArray();

        for(int i = 0; i < word.length(); i++){
            byte asciiCode =  (byte)wordArray[i];
            if(asciiCode >= 65 && asciiCode <= 90){ // 그 글자가 대문자인지?
                answer.append(convertBigLetter(wordArray[i]));
            }else if(asciiCode >= 97 && asciiCode <= 122){ // 그 글자가 소문자인지?
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
    boolean isViolatedRestrictions(String input){
        return !(1 <= input.length() && input.length() <= 1_000);
    }
}

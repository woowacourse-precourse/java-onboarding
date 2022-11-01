package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = getFrogWord(word);
        return answer;
    }

    /**
     * 문자를 청개구리 언어로 변환
     * @param target 청개구리 언어로 변환할 문자
     * @return 청개구리 언어로 변환된 문자
     */
    public static Character convertToFrogChar(Character target){
        Character frogChar = null;
        if(!Character.isAlphabetic(target)){
            frogChar = target;
        }
        if(Character.isUpperCase(target)){
            frogChar = (char)('Z' - target + 'A');
        }
        if(Character.isLowerCase(target)){
            frogChar = (char)('z' - target + 'a');
        }
        return frogChar;
    }

    /**
     * word를 청개구리식으로 변환된 문자열로 변환
     */
    public static String getFrogWord(String word){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<word.length(); i++){
            Character frogChar = convertToFrogChar(word.charAt(i));
            stringBuilder.append(frogChar);
        }
        return stringBuilder.toString();
    }
}

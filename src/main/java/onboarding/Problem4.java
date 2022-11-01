package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if(Character.isAlphabetic(word.charAt(i))){
                answer.append(reverseAlphabet(word.charAt(i)));
            }else{
                answer.append(word.charAt(i));
            }
        }

        return answer.toString();
    }

    /**
     * 알파벳을 거꾸로 반환
     */
    public static Character reverseAlphabet(char c){
        if(Character.isLowerCase(c)){
            return ((char) ('z' + 'a' - c));
        }else{
            return ((char) ('Z' + 'A' - c));
        }
    }
}

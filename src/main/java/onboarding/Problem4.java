package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0 ; i < word.length() ; i++){
            answer.append(convertCharcter(word.charAt(i)));
        }
        return answer.toString();
    }
    public static char convertCharcter(Character ch){
        int sumUpper = 'A' + 'Z';
        int sumLower = 'a' + 'z';
        if (Character.isUpperCase(ch)){
            return (char)(sumUpper - Integer.valueOf(ch));
        }
        else if (Character.isLowerCase(ch)){
            return (char)(sumLower - Integer.valueOf(ch));
        }
        else
            return ch;
    }
}

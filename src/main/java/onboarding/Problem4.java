package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            char letter = word.charAt(i);
            if(Character.isUpperCase(letter)){
                answer += convertUpperCaseLetterReverse(letter);
            }
            if(Character.isLowerCase(letter)){
                answer += convertLowerCaseLetterReverse(letter);
            }
        }
        return answer;
    }

    public static String convertUpperCaseLetterReverse(char letter){
        return Character.toString((char)(155 - letter));
    }

    public static String convertLowerCaseLetterReverse(char letter){
        return Character.toString((char)(219 - letter));
    }
}

package onboarding;

class constant{
    static final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
}
class validateString{
    public static boolean isLower(String alphabet){
        return alphabet.matches(alphabet.toLowerCase());
    }
    public static boolean isvalidLength(String word){
        return (word.length()>=1)&&(word.length()<=1000);
    }
    public static boolean isAlphabet(String alphabet){
        return alphabet.chars().allMatch(Character::isLetter);
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

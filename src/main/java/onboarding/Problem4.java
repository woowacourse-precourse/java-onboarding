package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String reverse = "";
        String[] splitWord = word.split("");
        for(int i=0; i< splitWord.length; i++){
            reverse = splitWord[i];
            if(!splitWord[i].equals(" "))
                reverse = compareLetter(splitWord[i]);
            answer+= reverse;
        }
        return answer;
    }
    private static String compareLetter(String letter){
        if(65 <= letter.charAt(0) && 90 >= letter.charAt(0))
            return reverseCapitalLetter(letter.charAt(0));
        return reverseSmallLetter(letter.charAt(0));
    }
    private static String reverseCapitalLetter(char letter){
        char reverseLetter = (char) (65 + 90 - letter);
        return  String.valueOf(reverseLetter);
    }
    private static String reverseSmallLetter(char letter){
        char reverseLetter = (char) (97 + 122 - letter);
        return  String.valueOf(reverseLetter);
    }
}

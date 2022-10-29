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
            return "대문자";
        return "소문자";
    }
}

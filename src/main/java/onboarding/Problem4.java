package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String reverse = "";
        String[] splitWord = word.split("");
        for(int i=0; i< splitWord.length; i++){
            reverse = splitWord[i];
            if(!splitWord[i].equals(" "))
                reverse = null;
            answer+= reverse;
        }
        return answer;
    }
}

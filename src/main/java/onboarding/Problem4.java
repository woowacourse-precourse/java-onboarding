package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < alphabet.length(); j++){
                if(word.charAt(i) == alphabet.charAt(j)){
                    answer = answer + alphabet.charAt(25 - j);
                }
                else{
                    answer = answer + word.charAt(i);
                }
            }
        }

        return answer;
    }
}

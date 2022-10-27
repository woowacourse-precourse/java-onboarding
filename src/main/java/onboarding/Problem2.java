package onboarding;

public class Problem2 {

    public static String removeRedundant(String target){
        String result = new String();
        boolean[] isRedundant = findRedundantPosition(target);
        for(int i = 0; i < target.length(); i++){
            if(!isRedundant[i]){
                result = result + target.charAt(i);
            }
        }
        return result;
    }
    public static boolean[] findRedundantPosition(String target){
        boolean[] isRedundant = new boolean[target.length()];
        for(int i = 0; i < isRedundant.length; i++){ //initialize array
            isRedundant[i] = false;
        }
        for(int currentPosition = 0; currentPosition < target.length() - 1; currentPosition++){
            int currentCharacter = target.charAt(currentPosition);
            int nextCharacter = target.charAt(currentPosition + 1);
            if(currentCharacter == nextCharacter){
                isRedundant[currentPosition] = true;
                isRedundant[currentPosition + 1] = true;
            }
        }
        return isRedundant;
    }

    public static boolean existsRedundant(String target){
        boolean result = false;
        for(int currentPosition = 0; currentPosition < target.length() - 1; currentPosition++) {
            int currentCharacter = target.charAt(currentPosition);
            int nextCharacter = target.charAt(currentPosition + 1);
            if (currentCharacter == nextCharacter) {
                result = true;
                return result;
            }
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = cryptogram;
        while(existsRedundant(answer)){
            answer = removeRedundant(answer);
        }
        return answer;
    }
}

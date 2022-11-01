package onboarding;

public class Problem2 {
    public static String removeRedundant(String target){
        StringBuilder result = new StringBuilder();
        boolean[] isRedundant = findRedundantPosition(target);
        for(int i = 0; i < target.length(); i++){
            if(!isRedundant[i]){ //todo refactor
                result.append(target.charAt(i));
            }
        }
        return result.toString();
    }

    public static boolean[] findRedundantPosition(String target){
        boolean[] isRedundant = new boolean[target.length()];
        for(int currentPosition = 0; currentPosition < target.length() - 1; currentPosition++){
            markRedundantCharacters(target, isRedundant, currentPosition);
        }
        return isRedundant;
    }

    public static void markRedundantCharacters(String target, boolean[] isRedundant, int currentPosition){
        int currentCharacter = target.charAt(currentPosition);
        int nextCharacter = target.charAt(currentPosition + 1);
        if(currentCharacter == nextCharacter){
            isRedundant[currentPosition] = true;
            isRedundant[currentPosition + 1] = true;
        }
    }
    public static boolean existsRedundant(String target){
        for(int currentPosition = 0; currentPosition < target.length() - 1; currentPosition++) {
            int currentCharacter = target.charAt(currentPosition); //todo refactor
            int nextCharacter = target.charAt(currentPosition + 1);
            if (currentCharacter == nextCharacter) {
                return true;
            }
        }
        return false;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(existsRedundant(answer)){
            answer = removeRedundant(answer);
        }
        return answer;
    }
}

package onboarding;

public class Problem2 {

    public static String removeRedundant(String target){
        String result = new String();
        boolean isRedundant[] = new boolean[target.length()];

        //isRedundant = findRedundant();
        for(int i = 0; i < target.length(); i++){
            if(!isRedundant[i]){
                result = result + target.charAt(i);
            }
        }
        return result;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = cryptogram;
        /*while(existsRedundant(answer)){
            removeRedundant(answer);
        }*/
        return answer;
    }
}

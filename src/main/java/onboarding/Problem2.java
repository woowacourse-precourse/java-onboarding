package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = isOverlap(cryptogram);
        return answer;
    }

    private static String isOverlap(String secretMessage){
        for(int i = 0; i < secretMessage.length() - 1; i++){
            String[] arrayString = secretMessage.split("");
            if(arrayString[i].equals(arrayString[i+1])){
                secretMessage = overlapDelete(secretMessage, i);
                i = -1;
            }
        }
        return secretMessage;
    }

    private static String overlapDelete(String deleteMessage, int idx){
        return deleteMessage.substring(0,idx) + deleteMessage.substring(idx+2);
    }
}

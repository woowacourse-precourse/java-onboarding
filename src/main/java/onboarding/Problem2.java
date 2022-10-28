package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int overlap = isOverlap(cryptogram);
        return answer;
    }

    private static int isOverlap(String secretMessage){
        String[] arrayString = secretMessage.split("");
        for(int i = 0; i < arrayString.length - 1; i++){
            if(arrayString[i].equals(arrayString[i+1])){
                secretMessage = overlapDelete(secretMessage, i);
                i = -1;
            }
        }
        return 0;
    }

    private static String overlapDelete(String deleteMessage, int idx){
        return deleteMessage.substring(0,idx) + deleteMessage.substring(idx+2);
    }
}

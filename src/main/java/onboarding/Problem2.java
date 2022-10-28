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
                System.out.println("중복발생");
                return 1;
            }
        }
        return 0;
    }
}

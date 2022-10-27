package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static boolean[] checkDuplicateChar(String str){
        boolean[] isDuplicated = new boolean[str.length()];

        char currentChar = str.charAt(0);

        for(int i=1; i<str.length(); i++){
            char nextChar = str.charAt(i);
            if(nextChar==currentChar){
                isDuplicated[i] = true;
                isDuplicated[i-1] = true;
            }
            currentChar = nextChar;
        }

        return isDuplicated;
    }

}

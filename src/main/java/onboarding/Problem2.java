package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    public static boolean[] checkIsDuplicated(String cryptogram){
        boolean[] isDuplicated = new boolean[cryptogram.length()];
        int i = 0;
        for(int j = 1;j<cryptogram.length();i++,j++){
            char currentChar = cryptogram.charAt(i);
            char nextChar = cryptogram.charAt(j);
            if(currentChar==nextChar){
                isDuplicated[i] = true;
                isDuplicated[j] = true;
            }
        }
        return isDuplicated;
    }

}

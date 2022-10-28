package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int last_index = 0;
        for(int i = 0; i < cryptogram.length(); i++){
            last_index = isContinuous(cryptogram, i);
        }
        return answer;
    }
    public static int isContinuous(String cryptogram, int index) {
        int last_index = -1;
        if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) last_index = index + 1;
        return last_index;
    }
}

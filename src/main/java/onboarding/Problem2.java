package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        return answer;
    }


    public static int countDuplicateCharacter(String cryptogram, int startindex){
        int count = 0;
        int lastindex = startindex +1;

        if(lastindex == cryptogram.length()-1){
            return 1;
        }
        while (cryptogram.charAt(startindex) == cryptogram.charAt(lastindex)){
            count++;
            lastindex++;
        }
        return count;
    }
}

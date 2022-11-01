package onboarding;

public class Problem2 {
    private static int checkPoint(String str){
        for(int i = 0; i < str.length() -1; i++){
            if(str.charAt(i)==str.charAt(i+1)){
                return i;
            }
        }
        return -1;
    }

    public static String solution(String cryptogram) {
        int start = checkPoint(cryptogram);
        if(start < 0) return cryptogram;

        int last = start;

        while(last < cryptogram.length()){
            if(cryptogram.charAt(start) == cryptogram.charAt(last)){
                last++;
                continue;
            }
            break;
        }

        String answer = cryptogram.substring(0, start) + cryptogram.substring(last);
        return solution(answer);
    }
}

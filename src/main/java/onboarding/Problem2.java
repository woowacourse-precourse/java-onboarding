package onboarding;

public class Problem2 {
    private static int indexOfDuplicatedChar(String cryptogram) {
        for(int i=0; i<cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                return i;
        }
        return -1;
    }
    public static String solution(String cryptogram) {
        while(true) {
            int idx = indexOfDuplicatedChar(cryptogram);
            if(idx == -1) // 중복 문자가 없는 경우
                break;
            cryptogram = cryptogram.substring(0,idx) + cryptogram.substring(idx+2);
        }
        return cryptogram;
    }
}

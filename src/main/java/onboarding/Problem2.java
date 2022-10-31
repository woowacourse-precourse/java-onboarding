package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean isDuplicateExist = false;
        int si = 0, ei = 0;
        for(int i = 1; i < cryptogram.length(); i++) {
            if(cryptogram.charAt(si) == cryptogram.charAt(i)) {
                ei = i;
                isDuplicateExist = true;
            } else {
                if(si < ei) {
                    cryptogram = cryptogram.substring(0, si) + cryptogram.substring(ei+1);
                    i = si; // 중복을 제거하고 나서는 중복 체크가 진행되었던 곳에서 시작
                }
                si = i;
                ei = i;
            }
        }
        if(si < ei) {
            cryptogram = cryptogram.substring(0, si) + cryptogram.substring(ei+1);
        }
        if(isDuplicateExist) return solution(cryptogram);
        return cryptogram;
    }
}

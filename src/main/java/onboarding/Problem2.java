package onboarding;

public class Problem2 {

    /*
    * 1. 두 개의 연속하는 중복 문자를 제거
    * 2. 중복하는 문자가 없다면 return 한다.
    * */

    // 중복을 체크하는 함수
    public static int checkDuplication(String str) {

        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) return i;
        }
        return -1;
    }

    // checkDuplication() 을 이용해 중복을 체크하고, 중복된 문자를 제거하는 재귀함수
    public static String solution(String cryptogram) {
        int rmIndex = checkDuplication(cryptogram);
        if (rmIndex == -1) return cryptogram;
        int end = rmIndex;

        for (; end < cryptogram.length(); end++) {
            if(cryptogram.charAt(rmIndex) != cryptogram.charAt(end)) {
                break;
            }
        }
        cryptogram = cryptogram.substring(0,rmIndex) + cryptogram.substring(end);

        return solution(cryptogram);
    }
}

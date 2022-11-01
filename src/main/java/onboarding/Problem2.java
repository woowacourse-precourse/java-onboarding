package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    /* 기능 단위
     * 1. 연속하는 중복 문자 찾기
     *   a. 암호문 사이즈까지 반복하여 i와 i+1 비교
     *   b. 중복이 없을 떄까지 1 반복
     * 2. 1에서 찾은 연속하는 중복 문자 제거하기
     *   a. remove를 사용하여 제거하기
     *   b. 제거한 후 암호문 사이즈 줄이기
     *   c. i = i - 1
     * */
    private static List<String> findDuplicateChar(List<String> cryptoList) {
        int dupStartIndex = -1;
        boolean isDuplicated = true;
        while(isDuplicated) {
            isDuplicated = false;
            if (dupStartIndex != -1) {
                cryptoList.remove(dupStartIndex);
            }
            for(int i = 0; i < cryptoList.size() - 1; i++) {
                if(cryptoList.get(i).equals(cryptoList.get(i+1))) {
                    cryptoList.remove(i+1);
                    isDuplicated = true;
                    if (dupStartIndex == -1)    dupStartIndex = i;
                    i = i - 1;
                } else if (dupStartIndex != -1) {
                    cryptoList.remove(dupStartIndex);
                    dupStartIndex = -1;
                    i = i - 1;
                }
            }
            System.out.println(cryptoList);
        }
        return cryptoList;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> cryptoList = new ArrayList<String>(Arrays.asList(cryptogram.split("")));
        System.out.println("crypto: " + cryptogram);
        cryptoList = findDuplicateChar(cryptoList);
        System.out.println("final:" + cryptoList);
        answer = String.join("", cryptoList);
        return answer;
    }
}

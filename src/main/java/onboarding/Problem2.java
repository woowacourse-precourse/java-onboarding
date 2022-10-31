package onboarding;

import java.io.IOException;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 같은 문자 반복 시, index를 저장할 start, end 변수
        int startNum = 0, endNum = 0;

        for (int i = 0; i < cryptogram.length()-1; i++) {
            // 같은 문자 반복 시, 시작 index를 startNum에저장, 마지막 index를 endNum에 저장
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                startNum = i;

                // 문자열의 마지막 문자가 반복될 시 배열크기 초과하기 때문에 try-catch 사용
                try {
                    while (cryptogram.charAt(startNum) == cryptogram.charAt(++i)) ;
                }catch (IndexOutOfBoundsException e){

                }
                endNum = i;

                // 문자열의 startNum부터 endNum까지 제거
                StringBuffer str=new StringBuffer(cryptogram);
                cryptogram=str.delete(startNum,endNum).toString();
                i=-1;
            }
        }
        return cryptogram;
    }
}
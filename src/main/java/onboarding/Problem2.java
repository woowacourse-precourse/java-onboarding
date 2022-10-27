package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (isEncrypted(cryptogram)) {
            cryptogram = decryption(cryptogram);
        }

        return cryptogram;
    }

    /**
     * 복호화가 필요한 문자열을 복호화하는 메서드
     *
     * @param cryptogram 현재 cryptogram
     * @return 복호화한 cryptogram
     */
    public static String decryption(String cryptogram) {

        String[] arr = cryptogram.split("");

        //직전 인덱스
        int lastIndex = 0;

        //연속상태의 시작 인덱스
        int startConsecutive = 0;

        //연속상태인지 아닌지 체크하는 변수
        boolean isConsecutive = false;

        for (int i = 1; i < arr.length; i++) {
            //현재 인덱스와 전 인덱스의 글자가 같은 경우
            if (arr[lastIndex].equals(arr[i])) {

                if (!isConsecutive) {
                    //연속 시작 시점 기록
                    startConsecutive = lastIndex;
                }
                isConsecutive = true;

                //현재 인덱스와 전 인덱스의 글자가 다른 경우
            } else {

                //글자가 연속 상태였다면 해당 글자들을 제거
                if (isConsecutive) {
                    for (int j = startConsecutive; j < i; j++) {
                        arr[j] = "";
                        System.out.println(startConsecutive);
                    }
                    isConsecutive = false;
                }
            }

            lastIndex++;
        }

        return Arrays.toString(arr);
    }

    /**
     * 현재 cryptogram 이 복호화가 필요한지 체크하는 메서드
     *
     * @param cryptogram 주어진 문자열
     * @return 복호화 필요 체크하는 boolean
     */
    public static boolean isEncrypted(String cryptogram) {

        int lastIndex = 0;
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(lastIndex) == cryptogram.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}

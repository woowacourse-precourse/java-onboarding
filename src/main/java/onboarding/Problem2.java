package onboarding;

/*
 * 기능 목록
 * 1. 연속하는 중복 문자의 마지막 인덱스 찾기
 * 2. 중복 문자 삭제 및 반복
 * */
public class Problem2 {

    // 연속하는 중복 문자의 마지막 인덱스 찾기
    public static int getLastIdx(String cryptogram, int start) {
        char word = cryptogram.charAt(start);
        while (start < cryptogram.length() && cryptogram.charAt(start) == word) {
            start++;
        }
        return start;
    }
    // 중복 문자 삭제 및 반복
    public static String getDeletedCryptogram(String cryptogram) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < cryptogram.length()-1; i++) {
                int pos = getLastIdx(cryptogram, i);
                // 연속하지 않음
                if (pos == i+1) continue;

                cryptogram = cryptogram.substring(0,i) + cryptogram.substring(pos);
                // 삭제 성공시 처음부터 다시
                flag = true;
                break;
            }
            if (!flag) break;
        }

        return cryptogram;
    }

    public static String solution(String cryptogram) {
        return getDeletedCryptogram(cryptogram);
    }
}

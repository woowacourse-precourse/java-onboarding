package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean flag = true;
        /*
        flag = 문자열에 중복이 있는지 확인하는 변수
        중복이 있으면 중복 제거 후 다음 중복을 찾는다
         */
        while (flag) {
            flag = false;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    flag = true;
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    break;
                }
            }
        }
        return cryptogram;
    }
}

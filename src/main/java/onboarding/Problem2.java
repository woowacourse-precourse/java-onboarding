package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (cryptogram != "") {
            String temp = roop(cryptogram);
            if (temp.equals(cryptogram)) {
                break;
            } else {
                cryptogram = temp;
            }
        }

        return cryptogram;
    }

    public static String roop(String cryptogram) {
        String ans = "";

        // 처음 값 추가
        if (cryptogram.charAt(0) != cryptogram.charAt(1)) {
            ans += cryptogram.charAt(0);
        }

        // 중간 값 저장
        // 좌, 우와 값이 모두 다르면 추가
        for (int i = 1; i < cryptogram.length() - 1; i++) {
            Character ch = cryptogram.charAt(i);

            if ((cryptogram.charAt(i - 1) != ch) && (cryptogram.charAt(i + 1) != ch)) {
                ans += cryptogram.charAt(i);
            }
        }

        // 마지막 값 추가
        if (cryptogram.charAt(cryptogram.length() - 1) != cryptogram.charAt(cryptogram.length() - 2)) {
            ans += cryptogram.charAt(cryptogram.length() - 1);
        }

        return ans;
    }
}
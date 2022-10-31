package onboarding;


class Decoder {
    private String cryptogram;

    public Decoder(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String decode() {
        while (isDuplicate()) {
//            eraseDuplicate();
        }
        return cryptogram;
    }

    public boolean isDuplicate() {
        for (int i = 0, len = cryptogram.length() - 1; i < len; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }


}

/*
기능 목록
1. 중복 유무 확인
2. 중복 없을때까지 중복 제거
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);

        return decoder.decode();
    }
}

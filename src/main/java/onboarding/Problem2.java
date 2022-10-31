package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 p = new Problem2();
        return p.returnWord(cryptogram);
    }

    // 문자열이 계속해서 나오면 체크, +1;
    public String returnWord(String cryptogram) {
        int count = 0, check = 0;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            boolean b = cryptogram.charAt(i) == cryptogram.charAt(i + 1);
            if (b && count > 0) {
                count++;
            } else if (b) {
                count++;
                check = i;
            }

            if (count > 0 && cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                cryptogram = subStringWord(cryptogram, check, count);
                i = -1;
                count = 0;
            } else if (count > 0 && i == cryptogram.length() - 2) {
                cryptogram = "";
            }
        }

        return cryptogram;
    }
    
    // 문자 자르는 메서드
    public String subStringWord(String cryptogram, int check, int count) {
        return cryptogram.substring(0, check) + cryptogram.substring(check + count + 1);
    }
}

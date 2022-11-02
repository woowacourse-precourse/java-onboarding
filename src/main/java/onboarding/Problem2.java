package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Boolean flag = true;
        char prev = '0';
        Integer count = 0;
        String result = "";
        while (flag) {
            for (int i = 0; i < cryptogram.length(); i++) {
                if (prev == cryptogram.charAt(i)) {
                    if (i == cryptogram.length()-1) {
                        result = result.substring(0, result.length() - 1);
                    }
                    count++;
                }
                else {
                    if (count > 0) {
                        result = result.substring(0, result.length() - 1);
                        count = 0;
                    }
                    result = result + cryptogram.charAt(i);
                    prev = cryptogram.charAt(i);

                }
            }
            if (cryptogram.length() == result.length()) flag = false;
            else {
                cryptogram = result;
                result = "";
                prev = '0';
            }
        }
        return result ;
    }
}

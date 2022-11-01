package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        for (;;) {
            String[] arrCryptogram = cryptogram.split("");
            StringBuilder decode = new StringBuilder();

            for (int i = 0; i < arrCryptogram.length; i++) {
                if (i == 0) { //첫글자일때
                    if (!arrCryptogram[i].equals(arrCryptogram[i + 1])) {
                        decode.append(arrCryptogram[i]);
                    }
                } else if (i == arrCryptogram.length - 1) { //마지막 글자일때
                    if (!arrCryptogram[i].equals(arrCryptogram[i - 1])) {
                        decode.append(arrCryptogram[i]);
                    }
                } else { //첫글자도 마지막글자도 아닐때
                    if (!arrCryptogram[i].equals(arrCryptogram[i - 1]) && !arrCryptogram[i].equals(arrCryptogram[i + 1])) {
                        decode.append(arrCryptogram[i]);
                    }
                }
            }
            cryptogram = decode.toString();

            if (arrCryptogram.length == cryptogram.length() || cryptogram.length()==0) {
                break;
            }
        }
        answer = cryptogram;

        return answer;
    }
}

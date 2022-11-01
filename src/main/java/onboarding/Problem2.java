package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        for (;;) {
            String[] cryptogramArr = cryptogram.split("");
            StringBuilder decode = new StringBuilder();

            for (int i = 0; i < cryptogramArr.length; i++) {
                if (i == 0) { //첫글자일때
                    if (!cryptogramArr[i].equals(cryptogramArr[i + 1])) {
                        decode.append(cryptogramArr[i]);
                    }
                } else if (i == cryptogramArr.length - 1) { //마지막 글자일때
                    if (!cryptogramArr[i].equals(cryptogramArr[i - 1])) {
                        decode.append(cryptogramArr[i]);
                    }
                } else { //첫글자도 마지막글자도 아닐때
                    if (!cryptogramArr[i].equals(cryptogramArr[i - 1]) && !cryptogramArr[i].equals(cryptogramArr[i + 1])) {
                        decode.append(cryptogramArr[i]);
                    }
                }
            }
            cryptogram = decode.toString();

            if (cryptogramArr.length == cryptogram.length() || cryptogram.length()==0) {
                break;
            }
        }
        answer = cryptogram;

        return answer;
    }
}

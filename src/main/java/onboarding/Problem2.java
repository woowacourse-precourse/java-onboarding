package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        String cryptoCleared = "";
        boolean flagDupli = true;

        while (flagDupli) {

            flagDupli = false;

            for (int i = 0; i < cryptogram.length(); i++) {
                if (i + 1 == cryptogram.length()) {
                    cryptoCleared += cryptogram.charAt(i);
                    break;
                }

                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    flagDupli = true;

                    for (int j = i + 1; j < cryptogram.length(); j++) {
                        if (cryptogram.charAt(i) != cryptogram.charAt(j)) {
                            //System.out.println(j);
                            i = j - 1;
                            break;
                        }
                        else if(j + 1 == cryptogram.length())
                            i = j;
                    }
                } else {
                    cryptoCleared += cryptogram.charAt(i);
                }
            }
            cryptogram = cryptoCleared;
            cryptoCleared = "";
            System.out.println(cryptogram);
        }

        answer = cryptogram;
        return answer;
    }
}

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        while (true) {
            if (check(cryptogram)) {
                answer = cryptogram;
                break;
            }

            StringBuilder tmpCrpto = new StringBuilder();

            for (int i = 0; i < cryptogram.length(); i++) {
                int redundantLen = 0;
                for (int j = i + 1; j < cryptogram.length(); j++) {
                    if (cryptogram.charAt(i) != cryptogram.charAt(j)) {
                        break;
                    } else {
                        redundantLen++;
                    }
                }

                if (redundantLen == 0) {
                    tmpCrpto.append(cryptogram.charAt(i));
                } else {
                    i += redundantLen; //중복되는 만큼 건너뜀
                }

            }
            cryptogram = tmpCrpto.toString();
        }

        return answer;
    }

    public static boolean check(String checkStr) {

        for (int i = 1; i < checkStr.length(); i++) {
            if (checkStr.charAt(i - 1) == checkStr.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

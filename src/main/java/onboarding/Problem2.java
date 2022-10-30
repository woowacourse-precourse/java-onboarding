package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        validateCryptogramLength(cryptogram);
        validateCryptogramLowerAlpha(cryptogram);

        String answer = "answer";
        answer = deDuplicateCryptogram(cryptogram);
        return answer;
    }

    private static String deDuplicateCryptogram(String cryptogram) {
        int i = 0;
        int leftEnd = 0;
        int rightStart = 0;

        String deDuplicated = cryptogram;

        while (true) {
            if (i == deDuplicated.length() - 1 || deDuplicated.length() == 0) {
                break;
            }

            if (deDuplicated.charAt(i) == deDuplicated.charAt(i + 1)) {
                for (int j = i + 1; j <= deDuplicated.length() - 1; j++) {
                    if (deDuplicated.charAt(i) == deDuplicated.charAt(j)) {
                        leftEnd = i;

                        if (j == deDuplicated.length() - 1) {
                            rightStart = j + 1;
                            break;
                        }

                    } else {
                        rightStart = j;
                        break;
                    }
                }

                String left = deDuplicated.substring(0, leftEnd);
                String right = deDuplicated.substring(rightStart, deDuplicated.length());

                deDuplicated = left + right;
                i = 0;
            }

            else i++;
        }

        return deDuplicated;
    }

    private static void validateCryptogramLength(String cryptogram) {
        if (cryptogram.length() == 0 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("cryptogram의 길이는 1이상, 1000이하여야 합니다.");
        }
    }

    private static void validateCryptogramLowerAlpha(String cryptogram) {
        for (int i = 0; i <= cryptogram.length() - 1; i++) {
            if (Character.isLowerCase(cryptogram.charAt(i)) == false) {
                throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 구성되어야 합니다.");
            }
        }
    }
}

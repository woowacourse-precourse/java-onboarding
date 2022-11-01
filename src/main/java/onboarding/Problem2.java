package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        answer = checkDuplicate(answer);

        return answer;
    }

    private static String checkDuplicate(String cryptogram) {
        String answer = "";
        boolean flag = true;

        while (flag) {
            StringBuilder check = new StringBuilder(cryptogram);
            StringBuilder sb = new StringBuilder();
            flag = false;

            checkDuplicateCharacters(check, sb);

            if (!(check.charAt(cryptogram.length() - 2) == check.charAt(cryptogram.length() - 1))) {
                sb.append(check.charAt(cryptogram.length() - 1));
            }


            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    cryptogram = sb.toString();
                    flag = true;
                }
            }

            answer = sb.toString();
        }



        return answer;

    }

    private static void checkDuplicateCharacters(StringBuilder check, StringBuilder sb) {
        for (int i = 0; i < check.length() - 1; i++) {
            if (check.charAt(i) == check.charAt(i + 1)) {
                i++;
            } else {
                sb.append(check.charAt(i));
            }
        }
    }
}

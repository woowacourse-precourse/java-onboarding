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
            StringBuilder chars = new StringBuilder(cryptogram);
            StringBuilder sb = new StringBuilder();
            flag = false;

            for (int i = 0; i < chars.length() - 1; i++) {
                if (chars.charAt(i) == chars.charAt(i + 1)) {
                    i++;
                } else {
                    sb.append(chars.charAt(i));
                }
            }

            if (!(chars.charAt(cryptogram.length() - 2) == chars.charAt(cryptogram.length() - 1))) {
                sb.append(chars.charAt(cryptogram.length() - 1));
            }

            System.out.println("sb = " + sb);

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
}

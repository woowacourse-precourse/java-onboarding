package onboarding;

public class Problem2 {

    public static boolean check(String cryptogram) {

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }

        return false;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        while (true) {

            int count = 1;
            int index = 0;
            char standard = cryptogram.charAt(0);

            for (int i = 1; i < cryptogram.length(); i++) {

                if (standard == cryptogram.charAt(i)) {

                    if (cryptogram.length() == 2) {
                        cryptogram = "";
                    }

                    count += 1;
                    index = i - 1;
                    continue;
                } else {


                    if (count >= 2) {
                        String substring = cryptogram.substring(index, index + count);
                        cryptogram = cryptogram.replaceFirst(substring, "");
                    }

                    if (i < cryptogram.length()) {
                        standard = cryptogram.charAt(i);
                        count = 1;
                    }
                }
            }


            if (check(cryptogram) == false) {
                break;
            }
        }

        answer = cryptogram;

        return answer;
    }
}

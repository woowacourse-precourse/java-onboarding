package onboarding;

public class Problem2 {
    static String decrypt(String cryptogram) {
        StringBuilder cryptcpy = new StringBuilder(cryptogram);
        char lastchar = '#';
        boolean check = true;

        while(check) {
            check = false;
            for (int i = 0; i < cryptcpy.length() - 1; i++) {
                lastchar = cryptcpy.charAt(i);
                int length = i + 1;

                while (true) {
                    if (length > cryptcpy.length()-1)
                        break;
                    if (lastchar == cryptcpy.charAt(length)) {
                        check = true;
                        length++;
                    } else {
                        break;
                    }
                }
                if (check) {
                    for (int j = 0; j < length - i; j++) {
                        cryptcpy.deleteCharAt(i);
                    }
                }
                if (check)
                    break;
            }
        }
        return new String(cryptcpy.toString());
    }
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = decrypt(cryptogram);
        return answer;
    }
}

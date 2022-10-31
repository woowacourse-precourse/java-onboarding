package onboarding;

/**
 * @작성자 rjsah09
 * @작성일 2022.10.31
 *
 * @수정내역
 * */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        if(cryptogram.length() == 1) {
            return answer;
        }

        answer = getAnswer(cryptogram);
        System.out.println(answer);
        return answer;
    }

    private static boolean isDuplicated(String str, int i) {
        char c = str.charAt(i);

        if(i == 0) {
            if(c != str.charAt(i + 1)) {
                return false;
            }
        } else if (i == str.length() - 1) {
            if(c != str.charAt(i - 1)) {
                return false;
            }
        } else {
            if(str.charAt(i - 1) != c && c != str.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private static String deleteDuplicated(String str) {
        if(str.length() == 0) {
            return str;
        }

        String decrypted = "";
        for(int i = 0; i < str.length(); i++) {
            if(!isDuplicated(str, i)) {
                decrypted += str.substring(i, i + 1);
            }
        }

        return decrypted;
    }

    private static String getAnswer(String str) {
        String prev = str;
        String decrypted = "";

        while(true) {
            decrypted = deleteDuplicated(prev);
            if(!decrypted.equals(prev)) {
                prev = decrypted;
            } else {
                break;
            }
        }

        return decrypted;
    }

}

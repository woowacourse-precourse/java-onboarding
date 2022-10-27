package onboarding;

import java.util.List;

public class Problem2 {
    static boolean exception(String cryptogram) {
        if (cryptogram.length() < 1 || 1000 <cryptogram.length())
            return true;
        for (char c : cryptogram.toCharArray()) {
            if (!(Character.isLowerCase(c)))
                return true;
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "";

        if(exception(cryptogram))
            return answer;
        return answer;
    }

    public static void main(String[] args) {

    }
}

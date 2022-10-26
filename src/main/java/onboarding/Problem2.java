package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder crpytogramToBuilder = new StringBuilder(cryptogram);
        int flag = 0;

        while (true) {
            int crpytogramLength = crpytogramToBuilder.length();
            Integer[] checkString = new Integer[crpytogramLength];

            for (int i = 0; i < crpytogramLength; i++)
                checkString[i] = 0;

            int checkNum = 1;
            for (int i = crpytogramLength - 1; i > 0; i--) {
                if (crpytogramToBuilder.charAt(i) == crpytogramToBuilder.charAt(i - 1)) {
                    checkString[i] = checkNum;
                    checkString[i - 1] = checkNum;
                    flag = 1;
                }
                else checkNum += 1;
            }
            for (int i = crpytogramLength - 1; i>= 0; i--) {
                if (checkString[i] > 0)
                    crpytogramToBuilder = crpytogramToBuilder.deleteCharAt(i);
            }
            checkNum = 1;
            if (flag != 1)
                break;
            flag = 0;
        }
        cryptogram =  crpytogramToBuilder.toString();

        return cryptogram;
    }
}

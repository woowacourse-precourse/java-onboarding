package onboarding;

public class Problem2 {
    public static String decrypt(String cryptogram) {
        String result = "";

        int i = 0;
        int j = 1;

        if (cryptogram.length() == 1)
            return cryptogram;

        while(i < cryptogram.length() - 1) {
            while(true) {
                char x = cryptogram.charAt(i);
                char y = cryptogram.charAt(j);
                if (x != y)
                    break;
                j += 1;
                if (j == cryptogram.length())
                    break;
            }
            if(i + 1 == j)
                result += cryptogram.charAt(i);
            if(j == cryptogram.length() - 1)
                result += cryptogram.charAt(j);
            i = j;
            j = i + 1;
        }
        
        return result;
    }

    public static String solution(String cryptogram) {
        String beforeDec = cryptogram;
        String afterDec;

        while(true) {
            afterDec = decrypt(beforeDec);
            if (beforeDec.equals(afterDec)) {
                break;
            }
            beforeDec = afterDec;
        }

        return afterDec;
    }
}

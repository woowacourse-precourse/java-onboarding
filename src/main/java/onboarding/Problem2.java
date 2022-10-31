package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = findDuplicate(cryptogram);
        return answer;
    }

    public static boolean isInRange(String cryptogram) {
        int length = cryptogram.length();
        if (length >= 1 && length <= 400)
            return true;

        return false;
    }

    public static boolean isLowerCase(String cryptogram) {
        String originCryptogram = cryptogram;
        String transCryptogram = cryptogram.toLowerCase();

        if (originCryptogram.equals(transCryptogram))
            return true;

        return false;
    }

    public static boolean isException(String cryptogram) {
        if (isInRange(cryptogram) && isLowerCase(cryptogram))
            return true;
        return false;
    }

    public static String deleteDuplicate(String cryptogram, Integer startIdx, Integer endIdx) {
        String Duplicate = cryptogram.substring(startIdx, endIdx + 1);
        return cryptogram.replaceAll(Duplicate, "");
    }

    public static String findDuplicate(String cryptogram) {
        int startIdx = 0;
        int endIdx = 0;
        boolean end = false;

        while(!end){
            for (int i = 0; i < cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    startIdx=i;
                    for (endIdx = startIdx+1; endIdx < cryptogram.length()-1; endIdx++) {
                        if(cryptogram.charAt(startIdx) == cryptogram.charAt(endIdx))
                            continue;
                        break;
                    }
                    cryptogram = deleteDuplicate(cryptogram, startIdx, endIdx-1);
                    i=-1;
                }
            }
            end = true;
        }
        return cryptogram;
    }
}

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decipherCode(cryptogram);
    }

    private static String decipherCode(String code) {
        while (!isNotDuplicate(code)) {
            code = decodingCode(code);
        }
        return code;
    }

    private static String decodingCode(String code) {
        int startDuplicate = findDuplicateStart(code);
        code = removeDuplicate(startDuplicate, code);
        return code;
    }
    private static String removeDuplicate(int startDuplicate, String code) {
        if (startDuplicate != -1) {
            int endDuplicate = findDuplicateEnd(code, startDuplicate);
            String decode = createDecode(code, startDuplicate, endDuplicate);
            code = isEndOneCycle(code, decode);
        }
        return code;
    }

    private static String isEndOneCycle(String code, String decode) {
        if (decode.equals(code)) {
            return code;
        }
        return decode;
    }


    private static boolean isNotDuplicate(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static int findDuplicateStart(String code) {
        int startIndex = -1;
        for (int i = 0; i < code.length()-1; i++) {
            if (code.charAt(i) == code.charAt(i+1)) {
                return i;
            }
        }
        return startIndex;
    }

    private static int findDuplicateEnd(String code, int startIndex) {
        if (code.length() == 2) {
            return startIndex+1;
        }
        for (int i = startIndex; i < code.length()-1; i++) {
            if (code.charAt(startIndex) != code.charAt(i+1)) {
                return i;
            }
        }
        return startIndex;
    }

    private static String createDecode(String code, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append(code);
        sb.replace(startIndex, endIndex+1, "");
        return sb.toString();

    }
}

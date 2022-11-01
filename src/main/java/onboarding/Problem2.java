package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        StringBuilder cryptogramBuilder = new StringBuilder(cryptogram);

        boolean checkConversion = true;
        while (checkConversion) {
            checkConversion = decode(cryptogramBuilder);
        }
        return cryptogramBuilder.toString();
    }

    public static boolean decode(StringBuilder encodedCode) {
        int count = 1;
        boolean flag = false;
        for (int i = 1; i < encodedCode.length(); i++) {
            if (checkSameChar(encodedCode, i - 1, i)) {
                count++;
                continue;
            }
            if (!checkSameChar(encodedCode, i - 1, i) && count >= 2) {
                flag = true;
                encodedCode.replace(i - count, i, getEmptySpace(count));
                clearSpaces(encodedCode);
                count = 1;
            }
        }
        if (count >= 2) {
            flag = true;
            encodedCode.replace(encodedCode.length() - count, encodedCode.length(), getEmptySpace(count));
            clearSpaces(encodedCode);
        }
        return flag;
    }

    private static boolean checkSameChar(StringBuilder encodedCode, int preIndex, int currentIndex) {
        return encodedCode.charAt(preIndex) == encodedCode.charAt(currentIndex);
    }

    private static void clearSpaces(StringBuilder encodedCode) {
        String clearSpaceCode = encodedCode.toString().replaceAll("\\s", "");
        encodedCode.setLength(0);
        encodedCode.append(clearSpaceCode);
    }

    private static String getEmptySpace(int count) {
        StringBuilder emptySpace = new StringBuilder();
        for (int i = 0; i < count; i++) {
            emptySpace.append(" ");
        }
        return emptySpace.toString();
    }
}

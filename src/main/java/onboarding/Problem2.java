package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {


        String answer = "answer";
        return answer;
    }

    public static String removeConsecutiveChar(String strInput) {
        String strOutput = "";
        int index = 0;
        int strLen = strInput.length();

        while (true) {
            if (index < strLen - 1) {
                if (strInput.charAt(index) != strInput.charAt(index + 1)) {
                    strOutput += strInput.charAt(index);
                    index++;
                    continue;
                }
                index += 2;
                continue;
            }
            if (index == strLen - 1) {
                strOutput += strInput.charAt(index);
                break;
            }
            if (index > strLen - 1) break;
        }

        return strOutput;
    }
}

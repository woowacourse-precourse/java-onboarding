package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String strTemp = cryptogram;

        while(true) {
            int length = strTemp.length();
            char strChar = strTemp.charAt(0);
            int strIndex = 0;
            boolean isChanged = false;

            if (length > 2) {
                for (int i = 1; i < length - 1; i++) {
                    length = strTemp.length();
                    strChar = strTemp.charAt(i);
                    strIndex = i;

                    if (strTemp.charAt(i + 1) == strChar) {
                        isChanged = true;
                        while(strTemp.charAt(i + 1) == strChar) {
                            i++;
                        }
                        if (strIndex == 0) {
                            if (i + 1 >= length) {
                                answer = "";
                                return answer;
                            }
                            strTemp = strTemp.substring(i + 1, length);
                        } else if (i + 1 >= length) {
                            strTemp = strTemp.substring(0, strIndex);
                        } else {
                            strTemp = strTemp.substring(0, strIndex) + strTemp.substring(i + 1, length);
                        }
                        i = strIndex - 1;
                    }
                    length = strTemp.length();
                }
                if (isChanged == false) {
                    answer = strTemp;
                    return answer;
                }
            } else {
                if (length == 1) {
                    answer = strTemp;
                    return answer;
                } else {
                    if (strTemp.charAt(0) == strTemp.charAt(1)) {
                        answer = "";
                    } else {
                        answer = "" + strTemp.charAt(0) + strTemp.charAt(1);
                    }
                    return answer;
                }
            }
        }
    }
}

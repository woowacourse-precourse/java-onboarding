package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] str = cryptogram.split("");
        StringBuilder sb = new StringBuilder();
        int length = cryptogram.length();
        int checkedLength = str.length;

        while (true) {
            String[] checkString = checkDuplicate(str);
            if (checkString[0].equals("")) {
                return "";
            }
            checkedLength = checkString.length;
            if (length == checkedLength) {
                for (String ch : checkString) {
                    sb.append(ch).append("");
                }
                return sb.toString();
            } else {
                str = checkString;
                length = checkedLength;
            }
        }
    }

    public static String[] checkDuplicate(String[] str) {
        StringBuilder sb = new StringBuilder();

        int length = str.length;

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                if (!str[i].equals(str[i - 1])) {
                    sb.append(str[i]);
                } else {
                    continue;
                }
            } else {
                if (!str[i].equals(str[i + 1])) {
                    if (i == 0) {
                        sb.append(str[i]);
                    } else {
                        if (!str[i].equals(str[i - 1])) {
                            sb.append(str[i]);
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return sb.toString().split("");
    }
}

package onboarding.problem3;

public class CheckNumbers {

    public int compare(String strNumber) {

        int result = 0;

        for (int strIndex = 0; strIndex < strNumber.length(); strIndex++) {

            if (strNumber.charAt(strIndex) == '3' ||
                strNumber.charAt(strIndex) == '6' ||
                strNumber.charAt(strIndex) == '9'  ) {

                result++;
            }
        }

        return result;
    }
}
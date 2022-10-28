package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (checkValidation(number)) {
            answer = getAnswer(number);
        } else {
            answer = -1;
        }

        return answer;
    }

    private static boolean checkValidation(int inputNumber) {
        // 1 이상 40,000 이하인 자연수인지 확인하다.
        if (!(1 <= inputNumber && inputNumber <= 40000)) {
            return false;
        }

        return true;
    }

    private static int getAnswer(int inputNumber) {
        String nowValueString = null;
        int result = 0;

        for(int i = 1; i <= inputNumber; i++) {
           nowValueString = String.valueOf(i);

           result += find369(nowValueString);
        }

        return result;
    }

    private static int find369(String inputString) {
        int result = 0;
        char nowChar;

        for (int i = 0; i < inputString.length(); i++) {
            nowChar = inputString.charAt(i);
            if (nowChar == '3' || nowChar == '6' || nowChar == '9') {
                result++;
            }
        }

        return result;
    }
}

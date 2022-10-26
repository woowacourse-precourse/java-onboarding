package onboarding;


// 뭔가 하드코딩한 느낌이나서 다시 살펴보면 좋을 것 같음
public class Problem3 {

    public static int countClap(int number) {
        int result = 0;

        for (int i = 1; i < number + 1; i++) {

            String currentValue = String.valueOf(i);
            int currentValueLength = currentValue.length();

            for (int j = 0; j < currentValueLength; j++) {
                if (currentValue.charAt(j) == '3') {
                    result += 1;
                } else if (currentValue.charAt(j) == '6') {
                    result += 1;
                } else if (currentValue.charAt(j) == '9') {
                    result += 1;
                }
            }
        }
        return result;
    }


    public static int solution(int number) {
        return countClap(number);
    }
}

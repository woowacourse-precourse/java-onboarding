package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int numOfClap = 0;

        for (int i = 1; i <= number; i++) {
            String strNumber = Integer.toString(i);

            for (int j = 0; j < strNumber.length(); j++) {

                if (strNumber.charAt(j) == '3') {
                    numOfClap++;
                } else if (strNumber.charAt(j) == '6') {
                    numOfClap++;
                } else if (strNumber.charAt(j) == '9') {
                    numOfClap++;
                }
            }
        }
        return numOfClap;
    }
}

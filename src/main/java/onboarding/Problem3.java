package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countTotalClap(number);
    }

    private static int countNumberClap(int number) {
        int count = 0;
        String numString = Integer.toString(number);

        for(int i = 0; i < numString.length(); i++) {
            if(numString.charAt(i) == '3' || numString.charAt(i) == '6' || numString.charAt(i) == '9')
                count += 1;
        }
        return count;
    }

    private static int countTotalClap(int number) {
        int count = 0;
        for (int  i= 1; i <= number; i++) {
            count += countNumberClap(i);
        }
        return count;
    }
}
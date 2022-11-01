package onboarding;

public class Problem3 {

    private static int getHandsClapCountBy369(int number) {
        int cnt = 0;

        for(int num = 1; num <= number; num++) {
            int tempNum = num;

            while(tempNum > 0) {
                int subNum = tempNum % 10;
                if(subNum == 3 || subNum == 6 || subNum == 9) cnt++;
                tempNum /= 10;
            }
        }

        return cnt;
    }

    public static int solution(int number) {

        return getHandsClapCountBy369(number);
    }
}

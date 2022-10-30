package onboarding;

public class Problem3 {

    public static int getNumber(int number) {
        int res = 0;
        if (number < 10) {
            if (number == 3 || number == 6 || number == 9) {
                return 1;
            }
        } else {

            while (number != 0) {
                int numToCheck = number % 10;
                if (numToCheck == 3 || numToCheck == 6 || numToCheck == 9) {
                    res++;
                }
                number /= 10;
            }
        }
        return res;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i =1; i<=number;i++){
            answer+=getNumber(i);
        }

        return answer;
    }
}

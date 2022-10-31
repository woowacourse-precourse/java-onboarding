package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(isValid(number)){
            return countClap(number);
        }else{
            return -1; // 잘못된 범위의 수를 입력했을때
        }
    }

    static int countClap(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += countThreeSixNine(i);
        }
        return sum;
    }

    static int countThreeSixNine(int number){
        int count = 0;
        while (number != 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    static boolean isValid(int number) {
        if (number < 1 || number > 10000)
            return false;
        else
            return true;
    }
}

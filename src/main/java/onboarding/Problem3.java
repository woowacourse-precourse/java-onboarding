package onboarding;

public class Problem3 {

    public static int solution(int number) {
        if(number<1||number>10000) return -1;
        int answer = 0;
        for (int i = 1; i <= number; i++) {
           answer+=getReturn(i);
        }

        return answer;
    }

    private static int getReturn(int num) {
        int price = 0;
        while (num != 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                price++;
            }
            num = num / 10;
        }

        return price;
    }
}

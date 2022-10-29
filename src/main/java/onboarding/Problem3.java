package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int total = 0;
        //1. 1부터 number까지 반복하며 3, 6, 9가 들어가는지 체크한다.
        for(int i = 1; i <= number; i++){
            //2. 하나의 수를 다 체크하면 3, 6, 9의 개수를 변수에 담는다.
            total += checkDigits(i);
        }

        //3. 3, 6, 9의 누계를 리턴한다.
        return total;
    }

    public static int checkDigits(int number) {
        int count = 0;

        while(number > 0) {
            if((number - 3) % 10 == 0 || (number - 6) % 10 == 0 || (number - 9) % 10 == 0) {
                count += 1;
            }
            number = number / 10;
        }

        return count;
    }
}

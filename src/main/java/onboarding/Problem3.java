package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        for(int i = 1; i < number+1; i++){
            int num = i;

            while (num / 10 != 0){  //일의 자리가 아닐때
                int remained = num % 10;
                if (remained != 0 && remained % 3 == 0){
                    count++;
                }
                num /= 10;
            }

            if (num != 0 && num % 3 == 0){  //일의자리일때
                count++;
            }
        }
        return count;
    }
}

package onboarding;
//1. 받은 숫자 -1을 하며 받은 숫자가 1이 될 때까지 반복한다.
//2. 숫자를 받아서 자리 수를 비교해 3, 6, 9가 있는지 확인하고 카운트 한다.
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int n, num;
        //1. 받은 숫자 -1을 하며 받은 숫자가 1이 될 때까지 반복한다.
        while(number > 0)
        {
            n = number;
            //2. 숫자를 받아서 자리 수를 비교해 3, 6, 9가 있는지 확인하고 카운트 한다.
            while(n > 0)
            {
                num = n % 10;
                if(num == 3 || num == 6 || num == 9)
                    answer += 1;
                n /= 10;
            }
            number -= 1;
        }
        return answer;
    }
}

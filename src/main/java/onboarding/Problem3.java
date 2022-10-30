package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(number<1 || number>10000)
            return -1;

        for(int i =1; i<number+1;i++){
            int tmp = i;
            while (tmp>0) {
                if ((tmp % 10) == 3 || (tmp % 10) == 6 || (tmp % 10) == 9)
                    answer++;
                tmp = tmp/10;
            }
        }
        return answer;
    }
}

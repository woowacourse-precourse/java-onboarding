package onboarding;



public class Problem3 {

    public static int getClapCount( int cur ,int sum){
        if (cur > 0) {
            int number = cur, tmp = cur%10, count = 0;
            while(number > 1){
                if(tmp == 3 || tmp == 6 || tmp == 9) count++;
                number = number/10;
                tmp = number%10;
            }
            return getClapCount(cur-1,sum+count);
        }
        return sum;
    }
    public static int solution(int number) {
        int answer = getClapCount(number, 0);

        return answer;
    }
}

package onboarding;
/*
1부터 number까지 돌면서 1의 자리부터 3의 배수가 있을때마다 answer++
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1 ; i <= number ; i ++) {
            int nowNum = i;
            while (nowNum != 0) {
                int thisNum = nowNum % 10;
                if(thisNum % 3 == 0 && thisNum != 0) {
                    answer++;
                }
                nowNum /= 10;
            }
        }
        return answer;
    }
}

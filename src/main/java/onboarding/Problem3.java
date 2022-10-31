package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return advancedCalc(number);
    }

    public static int advancedCalc(int number){
        /**
         *
         * 0 - 9 까지 3,6,9는 3개
         * 10 - 99 까지는 (0 - 9)까지 10개  + 앞자리가 3,6,9 인 경우
         * 100 - 999까지는 일의자리에서 개수 반복 + 십의자리에서 개수 반복 + 백의자리에서 3,6,9
         * ...
         * 규칙성을 보았을 때 이전의 값들로 현재의 값을 구할 수 있음.
         * dp[자릿 수][앞자리 수] 로 정의하여 자릿수에 3,6,9 를 모두 살펴보지 않아도 구할 수 있음.
         */
        int dp[][] = new int[6][11];

        /** 초기화 */
        for(int i = 3;i<=9;i++){
            dp[1][i] = dp[1][i - 1];
            if(i % 3 == 0)dp[1][i] += 1;
        }
        /**점화식*/
        for(int i = 2;i<=5;i++) {
            for (int k = 0; k <= 9; k++) {
                dp[i][k] = dp[i - 1][9];
                if (k == 1) dp[i][k] += dp[i - 1][9];
                if (k > 1) {
                    dp[i][k] += dp[i][k - 1];
                    if (k % 3 == 0) dp[i][k] += (int) Math.pow(10, i - 1);
                }
            }
        }
        /**주어진 수까지 계산된 dp테이블 바탕으로 큰수를 줄여가며 계산 */
        int ret = 0;
        while(number >= 10){
            int i = (int)Math.log10(number);
            int k = number / (int)Math.pow(10,i);
            number -= k * (int) Math.pow(10,i);
            ret += dp[i + 1][k - 1];
            if(k % 3 == 0) ret += number + 1;
        }
        ret += dp[1][number];
        return ret;
    }

    /**
     * 1부터 number까지 자릿수를 분해하며 하나씩 3,6,9인지 확인하여 카운트한다.
     */
    public static int originCalc(int number){
        int ret = 0;
        for(int i = 1;i<=number;i++) ret += calc(i);
        return ret;
    }

    public static int calc(int number){
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        String temp = sb.toString();
        int ret = 0;
        for(int i =0;i<temp.length();i++){
            char t = temp.charAt(i);
            if(t == '3') ret++;
            if(t =='6') ret ++;
            if(t =='9') ret++;
        }
        return ret;
    }
}

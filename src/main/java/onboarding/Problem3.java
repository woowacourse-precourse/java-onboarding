package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String int2str = Integer.toString(number);
        int len = int2str.length();

        for (int i = 0; i<len; i++)
            answer += count369InThisDigit(int2str, i);

        return answer;
    }

    public static int count369BeforeThisNumber(int num){
        if (num <= 3) return 0; // 1,2,3 -> 0
        else if (num <= 6) return 1; // 1,2,"3",4,5,6 -> 1
        else return 2; // 1,2,"3",4,5,"6",7,8,9 -> 2
    }
    public static int count369InThisDigit(String int2str, int nowDigit){
        int len = int2str.length();

        /** if int = 4193, nowDigit = 2
         * 1st. 0 ~ 4099까지 십의자리에서 나타난 369의 횟수
         * 2nd. 4100 ~ 4189까지 십의자리에서 나타난 369의 횟수
         * 3rd. 4190 ~ 4193까지 십의자리에서 나타난 369의 횟수
         * */
        return count369InThisDigitFirst(int2str, nowDigit)
                + count369InThisDigitSecond(int2str, nowDigit)
                + count369InThisDigitThird(int2str, nowDigit);
        /**
         * ex) 4193
         * 천, 4 -> 1*1000
         * 백, 1 -> 0*100 + 3*100*4
         * 십. 9 -> 2*10 + 3*10*41 + ("3"+1)
         * 일, 3 -> 0*1 + 3*1*419 + (""+1)
         * */
    }
    public static int count369InThisDigitFirst(String int2str, int nowDigit){
        int len = int2str.length();
        if (nowDigit != 0){
            return (int) (3 * Math.pow(10, len-nowDigit-1)
                            * (Integer.parseInt(int2str.substring(0,nowDigit))));
        }
        else return 0;
    }
    public static int count369InThisDigitSecond(String int2str, int nowDigit){
        int len = int2str.length();
        return (int) (count369BeforeThisNumber(int2str.charAt(nowDigit) - '0')
                        * Math.pow(10, len-nowDigit-1));
    }
    public static int count369InThisDigitThird(String int2str, int nowDigit){
        int len = int2str.length();
        if ((int2str.charAt(nowDigit)-'0')%3 == 0){
            if (nowDigit == len-1)
                return 1;
            else
                return Integer.parseInt(int2str.substring(nowDigit+1)) + 1;
        }
        return 0;
    }
}
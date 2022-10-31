package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1;i<=number;i++)
            answer+=countThreeSixNine(i);

        return answer;
    }
    
    //숫자내 3,6,9 세기
    private static int countThreeSixNine(int num) {
        int ret = 0;
        while(num>0) {
            if (isThreeSixNine(num%10))
                ret++;

            num/=10;
        }
        return ret;
    }
    
    //3,6,9인지 체크
    private static boolean isThreeSixNine(int num) {
        return num==3||num==6||num==9;
    }
}

package onboarding;

/**
 *
 * /10 & %10 을 이용하여 각 자리에 숫자를 추출하고 %3을 이용하여 숫자가 3의 배수인지 확인.
 * 1 부터 주어진 숫자까지 반복문을 이용하여 3의 배수인지 확인
 * 3의 배수 확인할때마다 answer 변수 1씩 증가
 * answer 리턴
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

public class Problem3 {
    public static int solution(int number) {
        if(number <1 || number >10000) return -1;
        if(number<3) return 0;

        int answer = 0;

        for(int i=3; i<=number; i++){
            answer += factorsOfThree(i);
        }

        return answer;
    }

    /**
     * 일의 자리 숫자를 먼저 추출후 그 숫자가 3의 배수라면 count++
     * 주어진 매개변수가 10,100, ... 자리수를 가진 숫자 일수 있으므로 매개변수를 10으로 나누고
     * %을 사용하여 각 자리에 숫자가 3의 배수인지 확인후 맞다면 count++
     * 매개변수 /= 10 이 1보다 작을경우 count를 리턴
     *
     * @param number
     * @return 1 - number까지 몇번에 손벽을 쳐야하는지 숫자
     */

    public static int factorsOfThree(int number){
        int count = 0;
        while(number>=1){
            int onesDigit = number % 10;
            if(onesDigit%3==0 && onesDigit!=0) count++;
            number /= 10;
        }
        return count;
    }
}

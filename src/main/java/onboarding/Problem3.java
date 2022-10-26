package onboarding;

/*
 *  🚀 기능 명세
    입력으로 들어온 숫자에서 369의 개수를 반환해주는 메서드(getClapTimeOfNumber)
    1부터 주어진 수까지의 총 박수 횟수를 반환해주는 메서드(solution)
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1 ; i <= number ; i++)
            answer += getClapTimeOfNumber(i);

        return answer;
    }
    public static int getClapTimeOfNumber(int number){
        int clap = 0;

        while(number > 0){
            switch (number % 10){
                case 3:
                case 6:
                case 9:
                    clap += 1;
            }
            number /= 10;
        }
        return clap;
    }
}

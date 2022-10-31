package onboarding;

/*
기능 목록
1. 어떤 숫자에 대해 몇 번 박수를 쳐야하는지 계산하는 기능
2. 1부터 number까지 몇 번 박수를 쳐야하는지 계산하는 기능

 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //1부터 number까지 반복하며 손뼉을 쳐야하는 총 횟수 계산
        for (int num = 1; num <= number; num++) {
            answer += calculateHowManyClap(num);
        }
        return answer;
    }

    //전달받은 숫자에 대해 몇 번 박수를 쳐야하는지 계산하는 함수
    public static int calculateHowManyClap(int num) {
        int clap = (int) String.valueOf(num).chars().filter(a -> a == '3' || a == '6' || a == '9').count();
        return clap;
    }
}
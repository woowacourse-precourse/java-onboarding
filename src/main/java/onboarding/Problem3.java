package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    //전달받은 숫자에 대해 몇 번 박수를 쳐야하는지 계산하는 함수
    public static int calculateHowManyClap(int num) {
        int clap = (int) String.valueOf(num).chars().filter(a -> a == '3' || a == '6' || a == '9').count();
        return clap;
    }
}
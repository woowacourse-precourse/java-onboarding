package onboarding;

public class Problem3 {
    // 매개변수로 들어온 값에서 3,6,9 의 개수를 찾아 리턴하는 함수
    public static int isClap(int number){
        int toClap = 0;
        while (number > 0){
            int remain = number % 10;
            if(remain == 3 || remain == 6 || remain == 9){
                toClap += 1;
            }
            number /= 10;
        }
        return toClap;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

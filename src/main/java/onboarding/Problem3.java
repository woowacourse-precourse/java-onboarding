package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 0; i <= number; i++) {  // 0부터 number 까지 모든 숫자를 확인한다.
            answer += isIt369(i);
        }
        return answer;
    }

    // 입력된 숫자에 박수를 몇 번 처야하는지 확인하는 함수
    private static int isIt369(int number) {
        int clap = 0;
        // 각 자릿수를 하나씩 불러온다.
        while(number > 0){
            switch (number % 10) {
                // 박수를 칠지 (3,6,9 인지) 판단한다.
                case 3:
                case 6:
                case 9:
                    clap++;
                    number /= 10;
                    break;
                default:
                    number /= 10;
            }
        }
        return clap;
    }
}

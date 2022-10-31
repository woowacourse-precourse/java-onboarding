package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            int copyNum = i;
            //각각 자리에서 3,6,9가 있으면 더하는 방식
            while(copyNum > 0){
                int digitNum = copyNum % 10;
                if(digitNum == 3 || digitNum == 6 || digitNum == 9)
                    answer++;
                copyNum /= 10;
            }
        }

        return answer;
    }
}

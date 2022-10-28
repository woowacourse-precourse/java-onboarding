package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //입력값의 맨 뒷자리 수부터 차례대로 3,6,9가 들어가는지 검사
        for(int i = 1; i <= number; i++){
            int currentNumber = i; //갱신된 숫자를 저장
            while(currentNumber > 0){
                int tmp = currentNumber%10;
                if(tmp != 0 && tmp%3 == 0){
                    //3,6,9가 들어간 경우
                    //3,6,9가 포함된 횟수만큼 answer를 증가
                    answer++;
                }
                currentNumber /= 10;
            }
        }

        return answer;
    }
}

package onboarding;

public class Problem3 {
    // 1. 재귀로 풀이한다. 숫자를 1씩 증가하며 clap 함수로 박수 횟수를 계산한다.
    // 2. 특정 숫자를 10으로 나눠 자리수별로 확인한다. 3,6,9에 해당하면 cnt +1.
        // 만약 해당 숫자가 0이 될 경우(자리수를 다 확인함) 재귀에서 빠져나오면서 횟수를 return한다.
    
    // 자리수마다 3,6,9에 해당하는지 확인하는 메소드
    public static int clap(int num, int cnt){
        // 만약 자리수를 다 확인했다면 cnt 반환
        if (num == 0)
            return cnt;
        
        // 3,6,9에 해당하면 cnt(박수횟수) +1
        if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9){
            cnt ++;
        }
        // 다음 자리수 확인을 위한 나누기 10 연산
        num /= 10;
        // 재귀 함수로 모든 자리수 확인
        return clap(num, cnt);

    }
    public static int solution(int number) {

        int answer = 0;

        // 예외처리
        if(number < 1 || number > 10000){
            return answer;
        }
        // 1부터 주어진 number까지 모든 수의 경우 확인을 위한 반복문
        for (int i = 1;  i <= number; i++){
            int current = i;
            // 손뼉 횟수를 확인한다.
            answer = clap(current, answer);
        }

        return answer;
    }
}

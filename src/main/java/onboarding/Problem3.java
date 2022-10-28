package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0, temp,tempM; // 초기화
        for (int i = 1; i < number + 1; i++){ // 1부터 입력 숫자까지
            temp = i; // 차례대로 값을 넣어줌
            while (temp > 0){ // 0이 될때 까지
                tempM = temp % 10; // 1의 자리수
                if (tempM == 3 || tempM == 6 || tempM == 9) answer += 1; // 3,6,9 라면 +1
                temp /= 10; // 10으로 나눠줌
            }
        }
        return answer;
    }
}

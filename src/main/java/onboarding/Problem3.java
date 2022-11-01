package onboarding;
/*
* 1. 박수 카운트 체크하는 함수 생성
* 2. 조건(1 ~ 10,000)에 따라 1과 2가 들어오면 바로 0 리턴
* 3. 반복문을 따라서 몫과, 나머지를 통해 3, 6, 9를 구함.
* 4. 1부터 solution 파라미터 number까지 반복.
* */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 0; i <= number; i++) {
            answer += clapCount(i);
        }
        return answer;
    }

    public static int clapCount(int num) {
        int count = 0;
        if (num == 1 || num == 2) {
            return count;
        }
        while (num != 0) {
            int temp = num % 10;
            if (temp == 3 || temp == 6 || temp == 9) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}

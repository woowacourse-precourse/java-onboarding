package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // implement
        for(int i = 1; i <= number; ++i)
        {
            // 각 숫자마다 쳐야 하는 박수의 횟수를 구해서 더하기
            answer += getClaps(i);
        }
        return answer;
    }
    // 각 자릿수에 3, 6, 9가 있는 만큼 박수를 쳐야 한다.
    // 각 숫자마다 쳐야 하는 박수의 횟수를 구해서 반환
    static int getClaps(int input)
    {
        // 총 횟수를 저장하는 배열
        int count = 0;
        int in = input;

        // 입력받은 수가 0이 될 때까지 각 자릿수를 구해 3, 6, 9와 비교
        while(in != 0)
        {
            // 10으로 나눈 나머지가 3으로 나눠진다면: 3의 배수
            if((in % 10) % 3 == 0)
                ++count;

            // 자릿수 줄이기
            in /= 10;
        }
        return count;
    }
}

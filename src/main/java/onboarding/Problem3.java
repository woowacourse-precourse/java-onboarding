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
        // implement
        return input;
    }

}

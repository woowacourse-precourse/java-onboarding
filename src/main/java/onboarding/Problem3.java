package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int quotitent;

        for (int i=0; i<number;i++)
        {
            quotitent = i;

            while (quotitent != 0){
//            나머지가 3의 배수이면
                if ((quotitent % 10) % 3 == 0)
                {
                    answer++;
                    break;
                }
                quotitent /= 10;
            }

        }

        return answer;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) { int answer = 0;
        int idx = 1;

        while (idx <= number)
        {
            if (idx / 1000 > 0 && (idx / 1000) % 3 == 0)
                answer++;
            if (idx / 100 > 0 && (idx / 100) % 3 == 0)
                answer++;
            if (idx / 10 > 0 && (idx / 10) % 3 == 0)
                answer++;
            if (idx % 10 == 3 || idx % 10 == 6 || idx % 10 == 9)
                answer++;
            idx++;
        }
        return answer;
    }
}

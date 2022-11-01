package onboarding;

/*
1. 숫자 3, 6, 9일 때 박수 횟수를 증가시킨다.
2. 문자를 하나씩 순회하면서 3, 6, 9가 있는 경우 박수 횟수를 증가시킨다.
 */
public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        int fourAdd = 0;
        for (int i = 3; i <= number; ++i) {
            clapCount += countThreeSixNine(i);
        }
        return (clapCount);
    }
    private static int countThreeSixNine(int number) {
        int cnt = 0;
        while (number > 0)
        {
            if (isThreeSixNine(number % 10) == true)
                ++cnt;
            number /= 10;
        }
        return cnt;
    }
    private static boolean isThreeSixNine(int number)
    {
        if (number == 3 || number == 6 || number == 9)
            return true;
        return false;
    }
}

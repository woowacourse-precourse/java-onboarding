package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (number > 10000)
            return -1;
        for (int i = 0; i <= number; i++) {
            answer += count3(i);
        }
        return answer;
    }

    /**
     * 파라미터로 들어오는 숫자에 3이 몇번 들어갔는지 카운트
     * @param value
     * @return
     */
    public static int count3(int value) {
        int count = 0;
        char[] num = Integer.toString(value).toCharArray();

        for (int i = 0; i < num.length; i++) {
            if (num[i] == '3' || num[i] == '6' || num[i] == '9')
                count++;
        }
        return count;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] num = new int[number + 1];
        String s;
        int cnt;
        char[] threeSixNine = new char[]{'3', '6', '9'};
        int answer;
        for (int i = 3; i < number + 1; i++) {
            s = Integer.toString(i);
            cnt = 0;

            for (int j = 0; j < threeSixNine.length; j++) {
                cnt += countNum(s, threeSixNine[j]);
            }
            num[i] = num[i - 1] + cnt;
        }
        answer = num[number];
        return answer;
    }

    public static int countNum(String s, char num) {
        int count = 0;
        count += s.chars()
                  .filter(c -> c == num)
                  .count();
        return count;
    }
}

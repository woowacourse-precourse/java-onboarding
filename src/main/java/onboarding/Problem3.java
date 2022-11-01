package onboarding;

public class Problem3 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10000;
    private static final String[] CLAPNUMS = {"3", "6", "9"};
    public static int solution(int number) {
        numberRangeValidation(number);
        return getAnswer(number, CLAPNUMS);
    }

    private static int getAnswer(int number, String[] clapnums) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String now = Integer.toString(i);
            answer = getClappingNum(clapnums, answer, now);
        }
        return answer;
    }

    private static int getClappingNum(String[] clapnums, int answer, String now) {
        for (String clapnum : clapnums) {
            answer += now.chars().filter(it -> it == clapnum.charAt(0)).count();
        }
        return answer;
    }
    private static void numberRangeValidation(int number) {
        if (number < MIN_LENGTH || number > MAX_LENGTH) {
            throw new IllegalArgumentException("1 이상 10000 이하 숫자만 입력 가능합니다");
        }
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // 자리수별로 숫자 분리
    private static List<Integer> separateNumber(int num){
        List<Integer> separatedNumbers = new ArrayList<>();
        final int NOTATION = 10;

        while (num >= NOTATION){
            separatedNumbers.add(num % NOTATION);
            num /= NOTATION;
        }
        separatedNumbers.add(num % NOTATION);
        return separatedNumbers;
    }

}

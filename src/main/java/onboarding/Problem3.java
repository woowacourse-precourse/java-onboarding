package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String numberString = Integer.toString(i);
            char[] numberArr = numberString.toCharArray();

            for(int j=0;j<numberArr.length;j++) {
                if(numberArr[j] == '3' || numberArr[j] == '6' || numberArr[j] == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}

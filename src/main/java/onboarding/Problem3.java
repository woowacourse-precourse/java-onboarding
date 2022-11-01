package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String strNumber = Integer.toString(i);
            char[] arrNumber = strNumber.toCharArray();

            for(int j=0;j<arrNumber.length;j++) {
                if(arrNumber[j] == '3' || arrNumber[j] == '6' || arrNumber[j] == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}

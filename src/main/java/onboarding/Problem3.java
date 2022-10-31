package onboarding;

public class Problem3 {
    public static int solution(int number) {
        StringBuilder numberList = new StringBuilder();
        for (int k = 1; k <= number; k++){
            numberList.append(k);
        }
        int answer = 0;
        for (int k = 0; numberList.length() > k; k++){
            if (numberList.charAt(k) == '3' || numberList.charAt(k) == '6' || numberList.charAt(k) == '9'){
                answer += 1;
            }
        }
        return answer;
    }
}

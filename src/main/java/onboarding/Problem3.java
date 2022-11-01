package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 1부터 number까지 포함하여 반복
        for (int i = 3; i <= number; i++) {
            String numberStr = String.valueOf(i);
            answer += countThreeSixNineInStr(numberStr);
        }
        return answer;
    }
    
    /** String형식의 숫자를 인덱스로 순회하며 3, 6, 9의 숫자를 count하여 반환 */
    private static int countThreeSixNineInStr(String numberStr) {
        int count = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            char c = numberStr.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }
        return count;
    }
}

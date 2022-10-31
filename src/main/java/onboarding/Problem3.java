package onboarding;

public class Problem3 {
    // 반환값 count = 숫자에 포함된 3,6,9의 개수
    public static int countNum(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3') {
                count++;
            }
            if (str.charAt(i) == '6') {
                count++;
            }
            if (str.charAt(i) == '9') {
                count++;
            }
        }
        return count;
    }
    public static int solution(int number) {

        int answer = 0;

        // 제한사항: number는 1 이상 10,000 이하인 자연수이다.
        if ((number < 1) || (number > 10000)) {
            return -1;}

        for (int i = 1; i <= number; i++) {
            String str = i + "";
            answer = answer + countNum(str);
        }
        return answer;
    }
}

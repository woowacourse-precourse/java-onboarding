package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // 입력받은 문자열에 "3" "6" "9" 가 포함되어 있는 개수를 반환하는 메소드
    private static int count_3_6_9(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (Contain_3_6_9(num.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    // 입력받은 문자에 '3' '6' '9'가 포함되어 있는지 확인하는 메소드
    private static boolean Contain_3_6_9(char c) {
        return (c == '3' || c == '6' || c == '9');
    }

}

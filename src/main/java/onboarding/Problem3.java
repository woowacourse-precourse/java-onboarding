package onboarding;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(solution(33));
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count_369(String.valueOf(i));
        }
        return answer;
    }

    private static int count_369(String number) { //3, 6, 9를 가지고 있는만큼 카운트
        int count = 0;
        char[] nums = number.toCharArray();
        for (char num : nums) {
            if (num == '3' || num == '6' || num == '9') {
                count++;
            }
        }
        return count;
    }
}

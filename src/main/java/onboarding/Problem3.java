package onboarding;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(solution(33));
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count_369(i);
        }
        return answer;
    }

    private static int count_369(int number) { //3, 6, 9를 가지고 있는만큼 카운트
        String str_num = String.valueOf(number);
        int count = 0;
        char[] nums = str_num.toCharArray();
        for (char num : nums) {
            if (num == '3' || num == '6' || num == '9') {
                count++;
            }
        }
        return count;
    }
}

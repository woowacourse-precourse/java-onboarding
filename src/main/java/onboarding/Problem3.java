package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // for (int i = 1; i <= number; i++) {
        //     String temp = String.valueOf(i);
        //     for (int j = 0; j < temp.length(); j++) {
        //         if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
        //             answer += 1;
        //         }
        //     }
        // }

        for (int i =1; i <= number; i++){
            String[] nums = String.valueOf(i).split("");
            for (String num: nums) {
                if ("3".equals(num) || "6".equals(num) || "9".equals(num)) {
                    answer += 1;
                }
            }
        }
        

        return answer;
    }
}

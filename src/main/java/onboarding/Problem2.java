package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer ans = new StringBuffer(cryptogram);

        int left = 0;
        int right = 1;

        while (right < ans.length()){
            while (right < ans.length() && ans.charAt(left) == ans.charAt(right)){
                right += 1;
            }

            if (right - left > 1){
                ans.delete(left, right);
                left -= 1;
                right = left + 1;
                continue;
            }

            right += 1;
            left += 1;
        }

        return ans.toString();
    }
}

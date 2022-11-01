package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String s = Integer.toString(i);
            char[] arr = s.toCharArray();

            for(int j=0;j<arr.length;j++) {
                if(arr[j] == '3' || arr[j] == '6' || arr[j] == '9') {
                    answer++;
                }
            }
        }

        return answer;
    }
}

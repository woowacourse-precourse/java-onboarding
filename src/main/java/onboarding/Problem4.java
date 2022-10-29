package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr= word.toCharArray();

        for(int i=0;i<arr.length;i++) {
            //대문자
            if (65 <= arr[i] && arr[i] <= 90) {
                answer+=(char)(155-arr[i]);
            }
        }
        return answer;
    }
}
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
            //소문자
            else if (97 <= arr[i] && arr[i] <= 122) {
                answer+=(char)(219-arr[i]);
            }
            //알파벳 외
            else{
                answer+=arr[i];
            }
        }
        return answer;
    }
}
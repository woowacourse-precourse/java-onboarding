package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int[] arr = changeWord(word); // 아스키 코드로 변환

        return answer;
    }
    public static int[] changeWord(String word) {
        char[] arr = word.toCharArray();
        int[] check_list = new int[arr.length]; // 0으로 초기화된 배열

        for(int i = 0; i < arr.length; i++) {
            check_list[i] = arr[i];
        }
        return check_list;
    }
}

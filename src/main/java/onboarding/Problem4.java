package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int[] arr = changeWord(word); // 아스키 코드로 변환

        return calculateAscii(arr);
    }
    public static int[] changeWord(String word) {
        char[] arr = word.toCharArray();
        int[] check_list = new int[arr.length]; // 0으로 초기화된 배열

        for(int i = 0; i < arr.length; i++) {
            check_list[i] = arr[i];
        }
        return check_list;
    }
    public static String calculateAscii(int[] arr) {
        int n = arr.length;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++) {
            // Uppercase check
            if(64 < arr[i] && arr[i] < 91) {
                arr[i] = 155 - arr[i];
                result.append((char) arr[i]);
            } else if(96 < arr[i] && arr[i] < 123) {
                arr[i] = 219 - arr[i];
                result.append((char) arr[i]);
            } else if( arr[i] == 32) {
                result.append(' ');
            } else {
                result.append((char) arr[i]);
            }
        }
        return result.toString();
    }
}

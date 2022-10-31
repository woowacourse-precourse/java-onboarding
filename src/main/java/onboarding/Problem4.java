package onboarding;

public class Problem4 {
    public static String solution(String word) {

        word = flog(word);

        return word;
    }

    public static String flog(String word) { // 매개변수를 반대로 변환하는 메소드
        char[] arr = word.toCharArray();

        for(int i=0;i<arr.length;i++) {
            if((65<=arr[i])&&(arr[i]<=90)) {
                arr[i] = (char)(arr[i]-'A');
                arr[i] = (char) ('Z'-arr[i]);
                continue;
            }
            if(97<=arr[i]) {
                arr[i] = (char)(arr[i]-'a');
                arr[i] = (char)('z'-arr[i]);
            }
        }
        return new String(arr);
    }
}

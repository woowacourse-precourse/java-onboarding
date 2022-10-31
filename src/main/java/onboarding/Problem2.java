package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();

        String answer = "";
        int i = 0;
        char[] arr = new char[100];

        for(char x : cryptogram.toCharArray()) {
            String result = "";

            for(char y : arr) {
                if(y == x) {
                    result = null;
                    break;
                }
            }
            if(result != null) {
                sb.append(x);
                arr[i] = x;
                i++;
            }
        }
        return answer;
    }
}

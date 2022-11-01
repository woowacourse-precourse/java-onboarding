package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";


        for (;;) {
            String[] arr = cryptogram.split("");
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    if (!arr[i].equals(arr[i + 1])) {
                        sb.append(arr[i]);
                    }
                } else if (i == arr.length - 1) {
                    if (!arr[i].equals(arr[i - 1])) {
                        sb.append(arr[i]);
                    }
                } else {
                    if (!arr[i].equals(arr[i - 1]) && !arr[i].equals(arr[i + 1])) {
                        sb.append(arr[i]);
                    }
                }
            }
            cryptogram = sb.toString();

            if (arr.length == cryptogram.length() || cryptogram.length()==0) {
                break;
            }
        }
        answer = cryptogram;

        return answer;
    }
}

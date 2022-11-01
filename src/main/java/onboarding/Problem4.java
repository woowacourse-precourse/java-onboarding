package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (arr[i] >= 'A' && arr[i] <= 'M')
                arr[i] = (char) ('M' + ('N' - arr[i]));
            else if (arr[i] >= 'a' && arr[i] <= 'm')
                arr[i] = (char) ('m' + ('n' - arr[i]));
            else if (arr[i] >= 'N' && arr[i] <= 'Z')
                arr[i] = (char) ('N' + ('M' - arr[i]));
            else if (arr[i] >= 'n' && arr[i] <= 'z')
                arr[i] = (char) ('n' + ('m' - arr[i]));
        }
        answer = String.valueOf(arr);
        return answer;
    }
}

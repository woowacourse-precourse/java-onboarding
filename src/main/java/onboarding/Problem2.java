package onboarding;

public class Problem2 {
    public static String duple(String str) {
        String result = "";
        int n = str.length();

        if (n==0) {
            return result;
        }

        for (int i=0; i<n-1; i++) {
            if (str.charAt(i)!=str.charAt(i+1)) {
                result+=str.charAt(i);
            }
            else {
                i++;
            }
        }
        if (str.charAt(n-2)!=str.charAt(n-1)){
            result+=str.charAt(n-1);
        }

        return result;
    }
    public static String solution(String cryptogram) {
        String answer = "";
        String dupleResult = duple(cryptogram);

        while (true) {
            String dupleTest = dupleResult;
            dupleResult = duple(dupleResult);
            if (dupleTest.equals(dupleResult)) {
                break;
            }
        }
        answer = dupleResult;
        return answer;
    }
}

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeRedun(cryptogram);
        return answer;
    }
    private static String removeRedun(String right){
        String left = "";
        char stand = ' ';
        for(int i = 0; i < right.length(); i++){
            if(left.length() > 0) {
                stand = left.charAt(left.length() - 1);
                if (stand == right.charAt(i)) {
                    for (int j = i + 1; j < right.length(); j++) {
                        if (stand != right.charAt(j))
                            break;
                        i++;
                    }
                    left = left.substring(0, left.length() - 1);
                    continue;
                }
            }
            left += right.charAt(i);
        }
        return left;
    }
}

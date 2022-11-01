package onboarding;

public class Problem2 {
    public static boolean isAllIdentity(StringBuilder sb){
        int  idx = 0;
        while (idx < sb.length() - 1) {
            if (sb.charAt(idx) == sb.charAt(idx + 1)){
                sb.delete(idx, idx + 2);
                return (false);
            }
            idx++;
        }
        return (true);
    }
    public static String solution(String cryptogram) {
        String answer = new String();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); i++){
            sb.append(cryptogram.charAt(i));
        }
        while (true){
            if (isAllIdentity(sb))
                break;
        }
        answer = sb.toString();
        return answer;
    }
}

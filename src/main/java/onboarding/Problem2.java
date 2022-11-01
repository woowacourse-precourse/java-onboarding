package onboarding;

public class Problem2 {
    public static boolean isAllIdentity(StringBuilder sb){
        int  id = 0;
        while (id < sb.length() - 1) {
            if (sb.charAt(id) == sb.charAt(id + 1)){
                sb.delete(id, id + 2);
                return (false);
            }
            id++;
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
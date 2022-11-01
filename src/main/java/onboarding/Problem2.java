package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuilder sb = new StringBuilder(cryptogram);
        remover(sb, true);
        answer = sb.toString();
        return answer;
    }

    private static void remover(StringBuilder sb, boolean flag) {
        while(flag){
            flag = false;
            for(int i = 0; i< sb.length()-1; i++) {
                if(sb.charAt(i) == sb.charAt(i+1)){
                    sb.deleteCharAt(i+1); sb.deleteCharAt(i);
                    flag = true;
                }
            }
        }
    }
}

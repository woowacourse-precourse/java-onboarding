package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean flag = false;
        while (!flag){
            flag = true;
            for (int i =0; i < sb.length()-1; i++){
                if (sb.charAt(i) == sb.charAt(i+1)){
                    sb.delete(i,i + 2);
                    flag = false;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}

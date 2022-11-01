package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean flag=true;
        while(flag){
            flag = false;
            for(int i=0; i<sb.length()-1; i++) {
                if(sb.charAt(i) == sb.charAt(i+1)){
                    sb.deleteCharAt(i+1);
                    sb.deleteCharAt(i);
                    flag = true;
                }
            }
            System.out.println(sb);
        }
        answer = sb.toString();
        return answer;
    }
}

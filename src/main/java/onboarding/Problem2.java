package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        while(true){
            boolean check=false;
            boolean check1=false;
            for(int i=0;i<sb.length()-1;i++){
                while(sb.charAt(i)==sb.charAt(i+1)) {
                    sb = sb.deleteCharAt(i + 1);
                    check = true;
                    check1 = true;
                    if (sb.length() == 1) break;
                }
                if(check1){
                    sb=sb.deleteCharAt(i);
                    check1=false;
                }
            }
            if(!check) break;
        }
        return sb.toString();
    }
}

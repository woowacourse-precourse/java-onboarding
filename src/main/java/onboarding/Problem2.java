package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder str = new StringBuilder(cryptogram);
        boolean check = true;
        while(check){
            check = false;
            for(int i=0;i<str.length()-1;i++){
                if (str.charAt(i)==str.charAt(i+1)){
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    check = true;
                }
            }
        }
        return str.toString();
    }
}

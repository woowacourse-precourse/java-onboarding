package onboarding;

public class Problem2 {
    public static String removeDuplication(String s){
        StringBuilder sb=new StringBuilder(s);

        for(int i=0; i<sb.length()-1; i++){
            if(sb.charAt(i)==sb.charAt(i+1)){
                sb.delete(i,i+2);
                i--;
            }
        }

        return sb.toString();
    }

    public static String solution(String cryptogram) {
        int size=cryptogram.length();

        while(cryptogram.length()>1){
            cryptogram = removeDuplication(cryptogram);

            if(size==cryptogram.length())
                break;

            size=cryptogram.length();
        }

        return cryptogram;
    }
}

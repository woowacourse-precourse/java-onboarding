package onboarding;

public class Problem2 {
    public StringBuilder decrypt(StringBuilder sb, char c){
        return sb;
    }

    public static String solution(String cryptogram) {
        Problem2 T = new Problem2();
        StringBuilder sb = new StringBuilder();
        for(char c : cryptogram.toCharArray()){
            sb = T.decrypt(sb,c);
        }
        return sb.toString();
    }
}

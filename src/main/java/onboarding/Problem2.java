package onboarding;

public class Problem2 {
    public StringBuilder decrypt(StringBuilder sb, char c){
        if(sb.length()==0) return sb.append(c);

        int sbLastIndex = sb.length()-1;
        if(sb.charAt(sbLastIndex)==c) return sb.deleteCharAt(sbLastIndex);

        return sb.append(c);
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

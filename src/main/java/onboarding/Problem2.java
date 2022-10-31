package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean _flag = true;

        while(_flag){
            _flag = false;
            for(int i=0;i<sb.length()-1;i++){
                if(sb.charAt(i) == sb.charAt(i+1)){
                    int j;
                    for(j=i+1;j<sb.length();j++){
                        if(sb.charAt(i) != sb.charAt(j)) break;
                    }
                    // [i, j) 삭제
                    sb.delete(i,j);
                    _flag=true;
                }
            }
        }
        return sb.toString();
    }
}

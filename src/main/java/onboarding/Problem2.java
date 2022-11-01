package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer cryptogramBuffer = new StringBuffer(cryptogram);
        while(true){
            int cnt=0;
            char cach = ' ';
            for(int i=0;i<cryptogramBuffer.length()-1;i++){
                if(cryptogramBuffer.charAt(i)==cryptogramBuffer.charAt(i+1)){
                    cach = cryptogramBuffer.charAt(i);
                    cryptogramBuffer.delete(i,i+2);
                    i--;
                    cnt++;
                }else if(cach == cryptogramBuffer.charAt(i)){
                    cryptogramBuffer.deleteCharAt(i);
                    i--;
                }else{
                    cach = ' ';
                }
            }

            if(cnt == 0)
                break;
        }
        String answer = cryptogramBuffer.toString();
        return answer;
    }
}

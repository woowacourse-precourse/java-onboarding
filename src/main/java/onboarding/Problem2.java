package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true){
            boolean isFinish = true;
            StringBuilder sb = new StringBuilder();
            char std =cryptogram.charAt(0);
            int cnt=1;
            for(int i=1; i<cryptogram.length(); i++){
                char cur = cryptogram.charAt(i);
                if(std != cur){
                    if(cnt == 1)
                        sb.append(std);
                    std = cur;
                    cnt=1;

                }
                else{
                    isFinish = false;
                    cnt++;
                }
                if(i == cryptogram.length()-1 && cnt < 2)
                    sb.append(cur);
            }
            if(cryptogram.length() < 2)
                return cryptogram;

            cryptogram = sb.toString();
            if(isFinish || sb.toString().equals("")){
                break;
            }
        }
        return cryptogram;
    }
}

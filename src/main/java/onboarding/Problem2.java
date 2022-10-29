package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
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
                if(i == cryptogram.length()-1)
                    sb.append(cur);
            }
            else{
                cnt++;
            }
        }
        System.out.println(sb.toString());
        return answer;
    }
}

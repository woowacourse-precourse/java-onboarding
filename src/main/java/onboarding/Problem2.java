package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = cryptogram;
        while(true){
            int len = result.length();
            int point = -1;
            if(len<=1) return result;
            int more = 1;

            for(int i=1;i<len;i++){
                if(result.charAt(i)==result.charAt(i-1)){
                    char cont = result.charAt(i-1);
                    point = i-1;
                    while((i+1)<len && result.charAt(i+1)==cont){
                        i++;
                    }
                    //result 갱신
                    if((i+1)>=len) result = result.substring(0,point);
                    else result = result.substring(0,point) + result.substring(i+1);
                    more = 0;
                    break;
                }
            }
            if(more==1) return result;
        }
    }
}

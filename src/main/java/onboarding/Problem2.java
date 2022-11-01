package onboarding;

public class Problem2 {
    public static String deleteChar(String cur, int index){
        return cur.substring(0,index) + cur.substring(index+1);
    }
    public static String solution(String cryptogram) {
        int cnt=0;
        int _cnt=0;
        while(true){
            cnt=0;
            if(cryptogram.length()==0) break;
            char pre = cryptogram.charAt(0);
            for(int i=1; i<cryptogram.length(); i++){
                if(pre==cryptogram.charAt(i)){
                    cryptogram = deleteChar(cryptogram, i);
                    i--;
                    if(_cnt==0) {
                        cryptogram = deleteChar(cryptogram, i);
                        i--;
                    }
                    cnt++;
                    _cnt++;
                    continue;
                }
                pre = cryptogram.charAt(i);
                _cnt=0;
            }
            if(cnt==0) {
                break;
            }
        }
        return cryptogram;
    }
}


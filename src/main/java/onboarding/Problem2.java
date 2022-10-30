package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        myfunc02 mf=new myfunc02();

        while(!mf.chk_cond(cryptogram)){ /*중복이 있다면*/
        }
        return cryptogram;
    }
    public static class myfunc02{
        /**종료조건을 체크하는 메소드**/
        boolean chk_cond(String str){
            if (str.length()<=1) return true;
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i-1)==str.charAt(i)) return false; /*중복을 발견하면*/
            }
            return true;
        }
        /**다음 문자열을 만들어 리턴해주는 메소드*/
        String nxtCrypto(Stack<String> stk){
            StringBuilder nxt= new StringBuilder();
            if (stk.size()<1) return "";
            for (String s : stk) {
                nxt.append(s);
            }
            return nxt.toString();
        }
    }
}

package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        myfunc02 mf=new myfunc02();

        while(!mf.chk_cond(cryptogram)){ /*중복이 있다면*/
            cryptogram=mf.remove_rpt(cryptogram,mf);
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
        /** 중복을 제거하는 메인 기능 **/
        String remove_rpt(String cryptogram,myfunc02 mf){
            Stack<String> stk = new Stack<>();       /*스택 선언*/
            stk.push(String.valueOf(cryptogram.charAt(0)));/*초기화*/

            boolean flag=false; /*찌꺼기 확인용*/
            for (int i = 1; i < cryptogram.length(); i++) {
                if (!String.valueOf(cryptogram.charAt(i)).equals(stk.peek())){ /* 이전의 원소와 같지않다면 */
                    if (flag){ /*찌꺼기가 있었다면 제거해준다*/
                        stk.pop();
                        flag=false;
                    }
                    stk.push(String.valueOf(cryptogram.charAt(i)));
                }else { /*같은 원소가 있다면*/
                    flag=true; /*현재 원소를 스택에 추가하지 않고 넘어간다*/
                }
            }
            if (flag) stk.clear();
            return mf.nxtCrypto(stk); /*일순한 문자열을 다음 다시 재전달*/
        }
    }
}

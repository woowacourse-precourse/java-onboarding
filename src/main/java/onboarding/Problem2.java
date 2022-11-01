package onboarding;

import org.w3c.dom.Text;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer a = new StringBuffer(cryptogram);

        boolean end = false;
        while (true){
            if(a.length() >= 2 && !end){
                char c1 = a.charAt(0);

                for (int i = 1; i < a.length(); i++){


                    if (c1 == a.charAt(i)){
                        a.deleteCharAt(i);
                        a.deleteCharAt(i-1);
                        break;
                    }
                    else{
                        // 이전 글자와 이번 글자가 같지 않고 마지막 글자면
                        if (i == a.length() -1){
                            end = true;// 밖으로 나갈 표시를 해야함
                            break;
                        }
                        else{
                            c1 = a.charAt(i);
                        }
                    }
                }
            }
            else{
                break;
            }
        }
        String answer = String.valueOf(a);
        return answer;

        /*
        0. while(true)로 시작한다. 마지막엔 조건을 다 채웠는지 확인하고 break
            (아무 글자도 안 지웠는지, 글자 길이가 2개보다 적은지)
        1. 전체 알파벳 개수가 2개 이상인지 체크한다. 아니라면 while-break.
        2. 첫번째 알파벳을 미리 저장해두고 (ex : num1)

        4. for 문으로 두번째 알파벳부터 체크한다.
        5. num1과 이번 알파벳이 똑같다면 이번 알파벳을 지운 후 이전 알파벳을 지우고 break.
            (이전 알파벳을 먼저 지우면 현재 알파벳 위치가 변한다)
        6. 이전 알파벳을 지우지 않았거나,
           현재 위치가 글자가 아니라면 이번 알파벳을 num1에 저장해서  다음 알파벳으로 넘어간다.
        7. 마지막 위치에서 알파벳을 지우지 않았다면 종료.

        원랜 이번에 알파벳을 지운 num1 위치 -1 부분에서 다시 검사를 매번 시작하게 하면
        시간적 이득을 더 얻을 수 있을 것 같으나 나중에 하도록 하자.
        */
    }
}

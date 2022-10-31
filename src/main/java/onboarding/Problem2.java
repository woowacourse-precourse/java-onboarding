package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        /* do while */
        /* 시작할때의 문자열의 길이와 끝날때의 문자열의 길이가 같으면 종료 */
        /* substring 메소드를 활용하여 기록된 인덱스를 기준으로 앞뒤로 분리하여 다시 연결함 */
        String str = cryptogram;
        int startLen = 0;
        int endLen= 0;
        do
        {
            startLen = str.length();
            int cnt = 0;
            for(int i = 1; i < startLen; i++){
                if(str.charAt(i-1) == str.charAt(i)){
                    cnt = countDuplication(str,str.charAt(i),i + 1);
                    if(cnt > 0){
                        str = str.substring(0,i - 1) + str.substring(i + 1 + cnt, startLen);
                        break;
                    }
                    else{
                        str = str.substring(0,i-1) + str.substring( i + 1,startLen);
                    }
                    endLen = str.length();
                    break;
                }
            }
            endLen=str.length();

        }while (startLen != endLen);

        String answer = str;

        return answer;
    }

    /* 중복되는 문자의 개수 반환 */
    private static int countDuplication(String str, char currChar, int index){
        int cnt = 0;
        for(int i = index; i< str.length(); i++){
            if(currChar != str.charAt(i)){
                return cnt;
            }
            cnt ++;
        }
        return cnt;
    }

}

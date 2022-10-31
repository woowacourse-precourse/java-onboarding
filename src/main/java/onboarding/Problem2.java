package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        int cnt = 0;

        /* do while */
        /* 시작할때의 문자열의 길이와 끝날때의 문자열의 길이가 같으면 종료 */
        /* 현재 인덱스와, 이전 인덱스를 비교해서 같은 경우, 현재 인덱스를 기록 */
        /* substring 메소드를 활용하여 기록된 인덱스를 기준으로 앞뒤로 분리하여 다시 연결함*/
        String str = cryptogram;
        int startLen = 0;
        int endLen= 0;

        do
        {
            startLen = str.length();
            for(int i = 1; i < startLen; i++){
                if(str.charAt(i-1) == str.charAt(i)){
                    str = str.substring(0,i-1) + str.substring(i+1,startLen);
                    endLen = str.length();
                    break;
                }
            }
            endLen=str.length();

        }while (startLen != endLen);

        String answer = str;

        return answer;
    }
}

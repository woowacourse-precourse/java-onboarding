package onboarding;

import java.security.KeyStore;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // while문 탈출을 위한 flag
        boolean flag = true;

        while (flag){

            // StringBuilder를 만들어 중복되지 않다고 확인된 단어들을 담아준다
            StringBuilder sb = new StringBuilder();

            // 문자열이 비어있을땐 빈값 return
            if (cryptogram.length() == 0){
                return "";
            }

            // 가장 첫번째 문자를 prev에 담고, StringBuilder에도 담아준다
            char prev = cryptogram.charAt(0);
            sb.append(prev);

            // 두번째 문자부터 prev에 담긴 문자와 비교하고,
            // 두 문자가 같지 않다면, prev를 현재 문자로 갱신
            // 두 문자가 같다면, sb에 담긴 마지막 문자 지우기(중복된 문자는 모두 지워야하므로)
            for (int i = 1; i < cryptogram.length() ; i++) {
                char now = cryptogram.charAt(i);
                if (now != prev){
                    sb.append(now);
                    prev = now;
                }else{
                    sb.setLength(sb.length() - 1);
                    continue;
                }
            }

            // for문을 다 돌고 sb가 변함이 없다면 -> 더이상 반복 없음 while문 탈출
            if (sb.toString().equals(cryptogram)){
                flag = false;
            }else{
                // cryptogram를 중복을 지운 sb로 변경해준다
                cryptogram = sb.toString();
            }
        }

        answer = cryptogram;

        return answer;
    }
}

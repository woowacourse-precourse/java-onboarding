package onboarding;

import java.util.ArrayList;
/*
answer는 빈 문자열
*/
/*
1. 현재 문자열의 길이 저장
2. 문자열의 한 문자씩 접근
3. 이전 문자를 지정, 이전 문자와 다를때까지 다음 문자 탐색 이때, count를 추가하면서 탐색한다. 이전 문자가 없다면 previous에 문자 추가하고 다음문자 탐색(count 변화x)
4. 이전 문자와 다른 문자를 만나면 count 초기화, 만약 count가 0이면 이전 문자를 answer에 추가, 1 이상이면 연속된다는 뜻이므로, 이전 문자를 추가하진 않는다. 이전 문자와 다른 문자가 새로운 이전 문자가 된다.
5. 마지막 문자가 이전문자와 같으면 추가x 다르면 answer에 추가
6. 2,3,4,5 과정에서 문자열의 길이가 더이상 줄어들지 않을때까지 해당 과정을 반복한다.
*/
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);
        int before_len = 0;
        int count = 0;
        char now = 'X';
        char previous = 'S';
        while (true) {
            cryptogram = answer.toString();
            before_len = cryptogram.length();
            previous = 'S';
            answer = new StringBuilder();
            count = 0;
            for (int i = 0; i < before_len; i++) {
                now = cryptogram.charAt(i);
                if (previous == 'S') { // 첫번째 문자이면
                    previous = now;
                    continue;
                }
                if (previous == now) { // 이전이랑 현재 문자가 같으면
                    count += 1;
                }
                else { // 이전이랑 현재 문자가 다르면
                    if (count == 0)  {
                        // 문자가 연속되지 않음
                        answer.append(previous);
                    }
                    if (i == before_len -1) {
                        // 마지막 문자이고 연속되지 않으면 마지막 문자 추가
                        answer.append(now);
                    }
                    previous = now;
                    count = 0;
                }
            }
            if ((answer.length() == before_len) || answer.length() == 0)
                break;
        }
        return answer.toString();
    }
}

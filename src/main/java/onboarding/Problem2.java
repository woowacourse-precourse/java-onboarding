package onboarding;

import java.util.*;

/**
 * [풀이방법]
 * queue 에 넣으면서 확인하고 같으면 poll, 다르면 offer
 * <p>
 * -> 수정 -> 같은 단어가 2번이상 반복될 때 예외 발생
 * 같은 단어가 2번이상 반복될 때 그 단어를 저장해두고 한번에 지워버리는 방식으로 코드 구성
 * <p>
 * 1. 마지막 단어를 저장할 변수 선언, queue 가 비어있으면 offer
 * 2. 중복인지 확인할 단어와 queue 의 마지막 단어가 같으면 그대로 진행
 * 3. 중복인 단어가 나오면 lastWord 에 중복인 단어를 넣어주고, 비교할 단어와 같으면 그대로 진행
 * 4. 그대로 진행하다 다른 단어가 나오면 lastWord 비워주고, 다른 단어는 queue 에 넣어줌
 * <p>
 * -> 수정 -> 한 번에 모든 중복되는 단어를 지우는 것은 문제의 의도에 어긋나다고 판단, 문제에 주어진 예시대로 단계를 거쳐서 진행해야한다고 판단함.
 * ex) aabba 를 이전 버전의 코드로 테스트 진행시, 빈 문자열이 도출되는 문제가 발생, 단계를 거쳐서 진행한다면 aa bb 가 한단계에 사라져
 * 답으로 a 가 도출되는 것이 논리상으로 맞을것. 그래서 코드 수정을 진행함.
 **/
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            sb.append(cryptogram.charAt(i));
        }

        while (true) {
            int cnt = 0; // 중복되는 문자가 있는지 없는지 확인해주기 위한 변수
            boolean flag = false; // 중복되는 숫자가 있었는지 없었는지 확인하는 flag

            for (int i = 0; i < sb.length() - 1; i++) { // sb 길이만큼 진행
                int idx = i; // 시작 idx 를 저장
                if (sb.charAt(i) == sb.charAt(i + 1)) { // 만약 중복되는 문자가 나왔다면, 어디까지 이어지나 확인하기위해
                    for (int j = i + 1; j < sb.length(); j++) { // for 문을 i+1부터 돌려서 sb 길이만큼 진행
                        if (sb.charAt(i) == sb.charAt(j)) { // 처음 나온 문자와 j 번째가 중복된다면
                            idx = j; // idx 를 갱신하면서 진행
                        } else {
                            break; // 만약 중복되지 않는다면 break;
                        }
                    }
                    cnt++;
                    flag = true; // 중복된 if 문에 들어왔으니 flag 를 true 로 바꾸어줌 -> 중복이 한번이라도 있었으니
                }

                if (cnt > 0) { // 중복 되는 문자가 있었으니까
                    sb = sb.replace(i, idx + 1, ""); // 시작 i 부터 끝 idx (저장해두었던 변수) 까지 공백으로 치환
                    i--; // i 를 시작위치부터 다시 확인할 수 있게 위치를 -1 해줌
                    cnt = 0; // 중복되는 문자를 다시 확인하기 위해 값을 초기화해줌
                }
            }

            if (!flag) { // 만약 중복되는 문자가 없어서 flag 값이 변화하지 않았다면 더이상 바꿀 필요가 없어져 while 문 나오기
                break;
            }
        }

        return sb.toString();
    }
}
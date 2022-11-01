package onboarding;

import java.util.ArrayList;
import java.util.List;

class Cryptogram {
    /**
     * 암호 해석에 쓰이는 메소드를 정의한 클래스입니다.
     *
     * 모두 외부에 기능을 제공하기 위한 메소드들이고,
     * 인스턴스 변수의 값을 참조하거나 수정하지 않기 때문에
     * 불필요한 인스턴스의 생성을 줄이기 위해 클래스 메소드로 선언했습니다.
     *
     */

    public static List<List<Integer>> getDecodeList(String cryptogram) {
        /**
         * 주어진 문자열에서 중복 문자가 발견되는 위치의 인덱스 값들을 갖는 리스트를 반환하는 메소드
         */

        List<List<Integer>> indexList = new ArrayList<>();
        int idx = 0;

        while (idx <= cryptogram.length() - 2) {
            if (cryptogram.charAt(idx) == cryptogram.charAt(idx + 1)) {
                List<Integer> decodeIdx = new ArrayList<>();
                decodeIdx.add(idx); decodeIdx.add(idx + 1);
                indexList.add(decodeIdx);
                idx += 2;
            } else {
                idx += 1;
            }
        }

        return indexList;
    }
}

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);   // 잦은 String의 연산을 피하기 위해 StringBuilder를 이용
        List<List<Integer>> decodeList = Cryptogram.getDecodeList(cryptogram);

        while (decodeList.size() != 0) {
            for (int i = decodeList.size() - 1; i >= 0; i--) {
                answer.delete(decodeList.get(i).get(0), decodeList.get(i).get(1) + 1);
            }
            decodeList = Cryptogram.getDecodeList(answer.toString());
        }

        return answer.toString();
    }
}

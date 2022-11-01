package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {

    //반복되는 알파벳 인덱스 찾기
    private static List<Integer> findRepeatedIndex(String cryptogram) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                index.add(i);
                index.add(i+1);
            }
        }
        Set<Integer> set = new HashSet<>(index);
        List<Integer> repeatedIndex = new ArrayList<>(index);
        return repeatedIndex;
    }

    //인덱스에 해당하는 알파벳 지우기
    private static String removeRepeat(String crytogram, List<Integer> repeatedIndex) {
        StringBuffer strBCryptogram = new StringBuffer(crytogram);
        String excludeRepeat ="";

        //반복 횟수만큼 index가 작아짐
        int count = 0;
        for (Integer index : repeatedIndex) {
            strBCryptogram.delete(index - count, index + 1 - count);
            count++;
        }

        excludeRepeat = strBCryptogram.toString();
        return excludeRepeat;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        //removeRepeat 함수로 중복을 제거한 결과가 그 전과 같을 때 멈춤
        while (!answer.equals(removeRepeat(cryptogram, findRepeatedIndex(cryptogram)))) {
            answer = cryptogram;
            cryptogram = removeRepeat(cryptogram, findRepeatedIndex(cryptogram));
        }


        return answer;
    }
}

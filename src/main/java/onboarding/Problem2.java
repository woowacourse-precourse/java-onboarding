package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 *
 * Class : Problem 2
 *
 * Date : 2022.10.29
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. 암호문(cryptogram)을 입력받는다.
 * 2. 암호문(cryptogram)을 각 자리 별로 쪼개어 리스트에 저장시킨다.
 * 3. 리스트를 탐색하며 연속하는 중복 문자들의 인덱스 값을 찾아낸다.
 * 4. 리스트를 탐색하며 연속하는 중복 문자들을 삭제한다.
 * 5. 연속하는 중복된 문자들이 없을 때까지 3번을 반복한다.
 * 6. 연속하는 중복된 문자들이 없으면 결과를 출력한다.
 *
 * */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String crypto = cryptogram;

        // split the sting
        String[] cryptoWord = crypto.split("");
        ArrayList<String> cryptoList = new ArrayList<>(Arrays.asList(cryptoWord));

        // to find duplication words
        List<Integer> duplicationList = new ArrayList<>();
        for (int i = 1; i < cryptoList.size(); i++) {
            if (Objects.equals(cryptoList.get(i - 1), cryptoList.get(i))) {
                if (!duplicationList.contains(i - 1)){duplicationList.add(i - 1);}
                if (!duplicationList.contains(i)){duplicationList.add(i);}
            }
        }

        // to delete duplication words
        for (int i = duplicationList.size()-1; i >= 0; i--) {
            int removeIndex = duplicationList.get(i);
            cryptoList.remove(removeIndex);
        }

        System.out.println(cryptoList);
        return answer;
    }
}

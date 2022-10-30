package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 중복된 인덱스들을 overlapIndex 에 저장.
        ArrayList<Integer> overlapIndex = findOverlapIndex(cryptogram);

        // 중복된 인덱스 제거 메서드 remove()
        // cryptogram 초기화
        cryptogram = remove(cryptogram, overlapIndex);
        // 중복 index 가 있다면 초기화한 cryptogram 으로 재귀호출.
        if (overlapIndex.isEmpty()) {
            return cryptogram;
        }
        return solution(cryptogram);
    }

    // 중복 인덱스를 ArrayList<Integer> findOverlapIndex 에 저장.
    static ArrayList<Integer> findOverlapIndex(String cryptogram) {

        // cryptogram 을 char 배열로 만든후
        char[] chars = cryptogram.toCharArray();

        // 중복 인덱스 제거를 위해 set 을 이용.
        Set<Integer> set = new HashSet<>();


        // for 반복문을 이용하여 앞의 문자와 같을경우 앞인덱스와 현재 인덱스를 저장.
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                set.add(i - 1);
                set.add(i);
            }
        }
        // set 을 ArrayList 로 return
        return new ArrayList<>(set);
    }

    // 중복 문자 인덱스 제거 메서드
    static String remove(String cryptogram, ArrayList<Integer> list) {
        //StringBuilder 에 cryptogram 추가.
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram);

        // cryptogram 을 재정의 하기때문에 뒤에서부터 삭제하기 위해 reverse()
        Collections.reverse(list);


        // for 반복문을 돌며 StringBuilder 에서 중복 인덱스를 뒤에서부터 제거.
        for (int i = 0; i < list.size(); i++) {
            sb.delete(list.get(i), list.get(i) + 1);
            cryptogram = String.valueOf(sb);
        }

        return cryptogram;
    }
}
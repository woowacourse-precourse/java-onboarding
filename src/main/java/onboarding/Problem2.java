package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 중복된 인덱스들을 overlapIndex 에 저장.
        ArrayList<Integer> overlapIndex = findOverlapIndex(cryptogram);
        // 중복된 인덱스 제거 메서드 remove()
        remove(cryptogram, overlapIndex);
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
        ArrayList<Integer> list = new ArrayList<>();
        // cryptogram 을 char 배열로 만든후
        char[] chars = cryptogram.toCharArray();
        // for 반복문을 이용하여 앞의 문자와 같을경우 앞인덱스와 현재 인덱스를 저장.
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                list.add(i - 1);
                list.add(i);
            }
        }
        return list;
    }

    // 중복 문자 인덱스 제거 메서드
    static String remove(String cryptogram, ArrayList<Integer> list) {
        //StringBuilder 에 cryptogram 추가.
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram);

        // for 반복문을 돌며 StringBuilder 에서 중복 인덱스를 제거.
        for (int i = 0; i < list.size(); i++) {
            sb.delete(list.get(0), list.get(1));
            cryptogram = String.valueOf(sb);
        }

        return cryptogram;
    }
}

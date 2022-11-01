package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<IndexData> result;

        while(true) {
            result = findDuplicates(cryptogram);
            // 더 이상 중복 문자가 없을 때 까지 반복한다.
            if(result.isEmpty())
                break;

            while (!result.isEmpty()) {
                IndexData indexData = result.remove(result.size() - 1);  // 뒤쪽 인덱스부터 제거해야 index범위가 뒤틀리지 않음
                cryptogram = deleteString(cryptogram, indexData);
            }
        }

        return cryptogram;
    }

    // 문자열에서 연속하는 중복 문자들을 발견하는 함수
    private static List<IndexData> findDuplicates(String cryptogram) {
        List<IndexData> result = new ArrayList<>();
        // 값이 없을 때
        if(cryptogram.equals(""))
            return result;

        char before = cryptogram.charAt(0);
        int startIndex = 0;

        // 문자열 전체에서 중복 확인
        for(int i = 0; i < cryptogram.length() - 1; i++) {
            // 이전 글자와 현재 글자가 같지 않다면
            if(before != cryptogram.charAt(i + 1)) {
                // 기록된 인덱스를 결과에 추가한다.
                if (startIndex < i)
                    result.add(new IndexData(startIndex, i));
                before = cryptogram.charAt(i + 1);
                startIndex = i + 1;
            }
        }

        // 가장 뒤 두글자 확인
        if(cryptogram.length() - 1 > 0 && cryptogram.charAt(cryptogram.length() - 2) == cryptogram.charAt(cryptogram.length() - 1)) {
            result.add(new IndexData(cryptogram.length() - 2, cryptogram.length() - 1));
        }
        return result;
    }

    // 문자열에 특정 부분을 제거하는 함수
    private static String deleteString(String cryptogram, IndexData indexData) {
        cryptogram = cryptogram.substring(0, indexData.getStart()) + cryptogram.substring(indexData.getEnd() + 1);
        return cryptogram;
    }

    // 문자열의 시작과 끝 인덱스를 저장하기 위한 데이터 클래스
    public static class IndexData {
        private int start;
        private int end;

        IndexData(int start, int end) {
            setStart(start);
            setEnd(end);
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        public void setStart(int start) {
            this.start = start;
        }
        public void setEnd(int end) {
            this.end = end;
        }
    }
}

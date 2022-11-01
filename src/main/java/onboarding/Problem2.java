package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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

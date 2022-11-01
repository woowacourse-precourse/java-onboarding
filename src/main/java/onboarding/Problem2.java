package onboarding;

/**
 * 기능 목록
 * 1. 연속하는 중복 문자를 삭제하는 함수
 * 2. 연속하는 중복 문자가 있는지, 있다면 시작 위치와 끝 위치까지 찾는 함수
 * 3. 연속하는 중복 문자를 삭제할 수 있을 때까지 삭제하는 함수
 */
public class Problem2 {
    static class Duplication {
        Boolean isDupl;
        Integer startPos, endPos;

        public Duplication(boolean c, int s, int e) {
            this.isDupl = c;
            this.startPos = s;
            this.endPos = e;
        }
    }

    static String deleteDupl(String cry, int startPos, int endPos) {
        String front = cry.substring(0, startPos);
        String back = cry.substring(endPos);
        return front + back;
    }

    static Duplication hasDuplStr(String cry) {
        if (cry.isEmpty() || cry.length() == 1) {
            return new Duplication(false, 0, 0);
        }
        for (int i = 1; i < cry.length(); i++) {
            if (cry.charAt(i-1) != cry.charAt(i)) {
                continue;
            }
            int j;
            for (j = i + 1; j < cry.length(); j++) {
                if (cry.charAt(i-1) != cry.charAt(j)) {
                    break;
                }
            }
            return new Duplication(true, i-1, j);
        }
        return new Duplication(false, 0, 0);
    }

    public static String solution(String cryptogram) {
        while (true) {
            Duplication dupl = hasDuplStr(cryptogram);
            if (!dupl.isDupl)
                break;
            cryptogram = deleteDupl(cryptogram, dupl.startPos, dupl.endPos);
        }
        return cryptogram;
    }
}

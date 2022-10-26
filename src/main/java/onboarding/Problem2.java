package onboarding;

/**
 * 🚀 기능 요구 사항
 * 암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
 *
 * "browoanoommnaon"
 * "browoannaon"
 * "browoaaon"
 * "browoon"
 * "brown"
 * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 * cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
 * cryptogram은 알파벳 소문자로만 이루어져 있다.
 */

public class Problem2 {

    public static String solution(String cryptogram) {
        CryptogramUtil cryptogramUtil = new CryptogramUtil(cryptogram);
        while (cryptogramUtil.plusCurrentIdx() < cryptogramUtil.getCryptogram().length() - 1) {
            if (cryptogramUtil.getSameCount() == 1) {
                cryptogramUtil.setDuplicatedFirstIdx(cryptogramUtil.getCurrentIdx());
            }
            char currentChar = cryptogramUtil.getCryptogram().charAt(cryptogramUtil.getCurrentIdx());
            char nextChar = cryptogramUtil.getCryptogram().charAt(cryptogramUtil.getCurrentIdx() + 1);
            if (currentChar == nextChar) {
                cryptogramUtil.plusSameCount();
                continue;
            }
            if (cryptogramUtil.getSameCount() > 1) {
                resetCurrentIdxAndSameCount(cryptogramUtil);
            }
        }
        if (cryptogramUtil.getSameCount() > 1) {
            resetCurrentIdxAndSameCount(cryptogramUtil);
        }
        return cryptogramUtil.getCryptogram();
    }

    private static void resetCurrentIdxAndSameCount(CryptogramUtil cryptogramUtil) {
        cryptogramUtil.deleteDuplicatedChar();
        cryptogramUtil.minus2CurrentIdx(cryptogramUtil.getDuplicatedFirstIdx());
        cryptogramUtil.resetSameCount();
    }

    private static class CryptogramUtil {
        private StringBuilder cryptogramSb;
        private int sameCount;
        private int duplicatedFirstIdx;
        private int currentIdx;

        public CryptogramUtil(String cryptogram) {
            cryptogramSb = new StringBuilder(cryptogram);
            this.sameCount = 1;
            this.duplicatedFirstIdx = 0;
            this.currentIdx = -1;
        }

        public String getCryptogram() {
            return cryptogramSb.toString();
        }

        public void deleteDuplicatedChar() {
            this.cryptogramSb.delete(this.duplicatedFirstIdx, this.duplicatedFirstIdx + this.sameCount);
        }

        public int getSameCount() {
            return sameCount;
        }

        public void plusSameCount() {
            this.sameCount++;
        }

        public void resetSameCount() {
            this.sameCount = 1;
        }

        public int getDuplicatedFirstIdx() {
            return this.duplicatedFirstIdx;
        };

        public void setDuplicatedFirstIdx(int duplicatedFirstIdx) {
            this.duplicatedFirstIdx = duplicatedFirstIdx;
        }

        public int getCurrentIdx() {
            return currentIdx;
        }

        public int plusCurrentIdx() {
            return ++this.currentIdx;
        }

        public void minus2CurrentIdx(int duplicatedFirstIdx) {
            this.currentIdx = duplicatedFirstIdx - 2;
        }
    }
}

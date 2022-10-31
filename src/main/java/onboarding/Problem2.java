package onboarding;

//-----기능-----
//1. 중복 문자열 찾기
//2. 해당 문자열 제거
//3. 위 기능 반복

public class Problem2 {

    static class DupStr{
        private int startIdx;
        private int FinalIdx;

        private void startDupStr(String s) {
            for (int i = 0; i < s.length() - 1; i++)
            {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    this.startIdx = i;
                    this.FinalIdx = i + 1;
                    return ;
                }
            }
            this.startIdx = -1;
        }

        private void FinalDupStr(String s) {
            if (startIdx == -1)
                return;

            for (int i = this.FinalIdx + 1; i < s.length(); i++)
            {
                if (s.charAt(i) != s.charAt(i - 1))
                    return;
                FinalIdx++;
            }
        }

        private boolean isNextDup(String s){
            for (int i = FinalIdx + 1; i < s.length() - 1; i++)
            {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    FinalIdx++;
                    return true;
                }
                return false;
            }
            return false;
        }

        public int getStartIdx() {
            return startIdx;
        }

        public int getFinalIdx() {
            return FinalIdx;
        }

        public DupStr(String s) {
            startDupStr(s);
            while(true) {
                FinalDupStr(s);
                if (!isNextDup(s))
                    return;
            }
        }
    }

    public static String solution(String cryptogram) {
        int startIdx;
        int FinalIdx;
        while (true)
        {
            DupStr dupstr = new DupStr(cryptogram);
            startIdx = dupstr.getStartIdx();
            FinalIdx = dupstr.getFinalIdx();
            if (startIdx == -1)
                break;
            cryptogram = cryptogram.substring(0, startIdx) + cryptogram.substring(FinalIdx + 1);
        }
        return cryptogram;
    }
}

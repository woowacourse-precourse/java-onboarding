package onboarding;

//-----기능-----
//1. 중복 문자열 찾기
//2. 해당 문자열 제거
//3. 위 기능 반복

import java.util.Stack;

public class Problem2 {

    static class DupStr{
        private int cursor = 0;
        private int startIdx;
        private int FinalIdx;
        private Stack<Integer> idx = new Stack<>();

        private void startDupStr(String s) {
            for (int i = cursor; i < s.length() - 1; i++)
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
            }
            return false;
        }

        public Stack<Integer> getIdx() {
            return idx;
        }

        public DupStr(String s) {
            while(true) {
                startDupStr(s);
                FinalDupStr(s);
                this.cursor = FinalIdx + 1;
                idx.add(startIdx);
                idx.add(FinalIdx);
                if (!isNextDup(s))
                    return;
            }
        }
    }

    private static String getCryptogram(String cryptogram, Stack<Integer> idx) {
        int startIdx;
        int FinalIdx;
        while (!idx.isEmpty())
        {
            FinalIdx = idx.pop();
            startIdx = idx.pop();
            cryptogram = cryptogram.substring(0, startIdx) + cryptogram.substring(FinalIdx + 1);
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        while (true)
        {
            DupStr dupstr = new DupStr(cryptogram);
            Stack<Integer> idx = dupstr.getIdx();
            if (idx.get(0) == -1)
                break;
            cryptogram = getCryptogram(cryptogram, idx);
        }
        return cryptogram;
    }
}

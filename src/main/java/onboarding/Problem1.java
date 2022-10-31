package onboarding;

import java.util.List;

class Problem1 {
    public static int calculateMax(int val) {
        int[] arr = new int[3];
        int original_val = val;
        int tmp1 = 0;
        int tmp2 = 0;
        arr[0] = val / 100;
        val %= 100;
        arr[1] = val / 10;
        val %= 10;
        arr[2] = val;
        tmp1 = arr[0] + arr[1] + arr[2];
        if (original_val >= 100) {
            tmp2 = arr[0] * arr[1] * arr[2];
        }
        if (original_val >= 10 && original_val < 100) {
            tmp2 = arr[1] * arr[2];
        }
        if (original_val > 0 && original_val < 10) {
            tmp2 = arr[2];
        }
        if (tmp1 > tmp2)
            return tmp1;
        return tmp2;
    }

    public static int compareWhatIsMax(int val1, int val2) {
        if (val1 > val2)
            return val1;
        return val2;
    }

    public static int whoIsWinner(int pobi_score, int crong_score) {
        if (pobi_score > crong_score)
            return 1;
        if (pobi_score < crong_score)
            return 2;
        if (pobi_score == crong_score)
            return 0;
        return -1;
    }

    public static boolean catchException(List<Integer> list) {
        if ((list.get(0) + 1) != list.get(1))
            return true;
        if (list.size() != 2)
            return true;
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (catchException(pobi) || catchException(crong))
            return -1;
        int pobi1 = calculateMax(pobi.get(0));
        int pobi2 = calculateMax(pobi.get(1));
        int crong1 = calculateMax(crong.get(0));
        int crong2 = calculateMax(crong.get(1));
        int pobi_score = compareWhatIsMax(pobi1, pobi2);
        int crong_score = compareWhatIsMax(crong1, crong2);
        answer = whoIsWinner(pobi_score, crong_score);
        return answer;
    }
}
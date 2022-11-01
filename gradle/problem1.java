import java.util.List;

public class problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (pobi.size() != 2 || crong.size() != 2) {
            return -1;
        } else if (pobi.get(0) > pobi. get(1) || crong.get(0) > crong.get(1)) {
            return -1;
        }
        //test
        if (maxVal(pobi) > maxVal(crong)) {
            return 1;
        } else if (maxVal(pobi) == maxVal(crong)) {
            return 0;
        } else {
            return 2;
        }
    }
    public static int maxVal (List<Integer> arr) {
        int[] answer = new int[2];
        for (int i = 0; i < 2; i++) {
            String str = Integer.toString(arr.get(i));
            String[] s = str.split("");
            int sum = 0;
            int mul = 1;
            for (int j = 0; j < s.length; j++) {
                // 각 자리 숫자를 모두 다 더하거나
                sum += Integer.parseInt(s[j]);

                // 각 자리 수를 모두 곱해
                mul *= Integer.parseInt(s[j]);
            }
            // 왼쪽, 오른쪽 둘 중 큰 수
            answer[i] = Math.max(sum, mul);
        }
        return Math.max(answer[0], answer[1]);
    }
}

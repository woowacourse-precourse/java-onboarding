public class problem1 {

    public static void main(String[] args) {
        int[] pobi = {97, 98};
        int[] crong = {197, 198};
        System.out.println(solution(pobi, crong));
    }

    public static int solution(int[] pobi, int[] crong) {
        if (pobi.length != 2 || crong.length != 2) {
            return -1;
        } else if (pobi[0] > pobi[1] || crong[0] > crong[1]) {
            return -1;
        }
        if (maxVal(pobi) > maxVal(crong)) {
            return 1;
        } else if (maxVal(pobi) == maxVal(crong)) {
            return 0;
        } else {
            return 2;
        }

    }
    public static int maxVal (int[] arr) {
        int[] answer = new int[2];
        for (int i = 0; i < 2; i++) {
            String str = Integer.toString(arr[i]);
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

package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Problem1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // pobi
        st = new StringTokenizer(br.readLine());
        List<Integer> pobi = new ArrayList<>();
        while(st.hasMoreTokens()) {
            pobi.add(Integer.parseInt(st.nextToken()));
        }

        // crong
        st = new StringTokenizer(br.readLine());
        List<Integer> crong = new ArrayList<>();
        while(st.hasMoreTokens()) {
            crong.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(pobi, crong));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        boolean flag = true;

        // 예외상황
        // 1. 첫 번째 인자가 홀수인가?
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            flag = false;
        }
        // 2. 두 번째 인자가 짝수인가?
        if (pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            flag = false;
        }
        // 3. 첫 번째 인자와 두 번째 인자의 차이가 1인가?
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            flag = false;
        }

        if (flag) {
            int pobiScore = getScore(pobi);
            int crongScore = getScore(crong);

            if (pobiScore > crongScore) answer = 1;
            else if (pobiScore < crongScore) answer = 2;
            else answer = 0;
        }

        return answer;
    }

    private static int getScore(List<Integer> pages) {
        int lastScore = Integer.MIN_VALUE;
        int add=0, mul=1;
        for (int page : pages) {
            String pageString = String.valueOf(page);
            for (int i=0; i<pageString.length(); i++ ) {
                int n = Integer.parseInt(String.valueOf(pageString.charAt(i)));
                add += n;
                mul *= n;
            }
            lastScore = Math.max(lastScore, Math.max(add, mul));
            add = 0;
            mul = 1;
        }
        return lastScore;
    }
}
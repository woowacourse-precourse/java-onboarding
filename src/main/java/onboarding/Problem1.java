package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1) return -1;
        if (crong.get(1) - crong.get(0) != 1) return -1;

        int pobiMax = Integer.MIN_VALUE;
        for (Integer integer : pobi) {
            int[] arr = Stream.of(String.valueOf(integer).split("")).mapToInt(Integer::parseInt).toArray();
            int r = 2;
            Combination comb = new Combination(arr.length, r);
            comb.combination(arr, 0, 0, 0);
            ArrayList<ArrayList<Integer>> result = comb.getResult();

            for (ArrayList<Integer> integers : result) {
                int sum = getSum(integers);
                if (pobiMax < sum) {
                    pobiMax = sum;
                }
                int multi = getMulti(integers);
                if (pobiMax < multi) {
                    pobiMax = multi;
                }
            }
        }

        System.out.println("pobiMax = " + pobiMax);

        int crongMax = Integer.MIN_VALUE;
        for (Integer integer : crong) {
            int[] arr = Stream.of(String.valueOf(integer).split("")).mapToInt(Integer::parseInt).toArray();
            int r = 2;

            Combination comb = new Combination(arr.length, r);
            comb.combination(arr, 0, 0, 0);
            ArrayList<ArrayList<Integer>> result = comb.getResult();

            for (ArrayList<Integer> integers : result) {
                int sum = getSum(integers);
                if (crongMax < sum) {
                    crongMax = sum;
                }
                int multi = getMulti(integers);
                if (crongMax < multi) {
                    crongMax = multi;
                }
            }
        }

        System.out.println("crongMax = " + crongMax);

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else if (pobiMax == crongMax) {
            return 0;
        }

        return -1;
    }

    private static int getSum(ArrayList<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }

    private static int getMulti(ArrayList<Integer> integers) {
        int multi = 1;
        for (Integer integer : integers) {
            multi *= integer;
        }
        return multi;
    }


    static class Combination {
        private int n;
        private int r;
        private int [] now;
        private ArrayList<ArrayList<Integer>> result; //모든 조합

        public ArrayList<ArrayList<Integer>> getResult() {
            return result;
        }

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.result = new ArrayList<ArrayList<Integer>>();
        }

        public void combination(int[] arr, int depth, int index, int target) {
            if (depth == r) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(arr[now[i]]);
                }
                result.add(temp);
                return;
            }
            if (target == n) return;
            now[index] = target;
            combination(arr, depth + 1, index + 1, target + 1);
            combination(arr, depth, index, target + 1);
        }
    }
}
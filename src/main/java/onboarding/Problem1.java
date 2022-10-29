package onboarding;
import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static class Math{
        public static int getAdd(ArrayList<Integer> arr){
            int answer = 0;
            for (int num : arr){
                answer += num;
            }
            return answer;
        }

        public static int getMul(ArrayList<Integer> arr){
            int answer = 1;
            for (int num : arr){
                answer *= num;
            }
            return answer;
        }

        public static int Max(List<Integer> arr){
            int max = 0;
            for (int num : arr){
                ArrayList<Integer> arrNum = new ArrayList<>();
                while (num > 0){
                    arrNum.add(num%10);
                    num /= 10;
                }

                int add = Math.getAdd(arrNum);
                int mul = Math.getMul(arrNum);

                if (add > max){
                    max = add;
                }
                if (mul > max){
                    max = mul;
                }

            }
            return max;
        }

        public static boolean check(List<Integer> arr){
            int first = arr.get(0);
            int second = arr.get(1);

            // 연속되지 않은 수
            if (second != first + 1){
                return false;
            }
            // 1~400이 아닐 때
            else if (first < 1 || second > 400) {
                return false;
            }

            return true;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = Math.Max(pobi);
        int crongMax = Math.Max(crong);

        if (pobiMax == crongMax){
            answer = 0;
        } else if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        }

        boolean checkPobi = Math.check(pobi);
        boolean checkCrong = Math.check(crong);
        if (checkPobi == false || checkCrong == false){
            answer = -1;
        }

        return answer;
    }
}
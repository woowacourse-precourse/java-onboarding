package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static boolean validation(List<Integer> list) {
        if (1 > list.get(0) || 400 < list.get(0)) {
            return true;
        }
        if (1 > list.get(1) || 400 < list.get(1)) {
            return true;
        }
        return list.get(0) + 1 != list.get(1);
    }

    public static ArrayList<Integer> mod(List<Integer> list) {
        ArrayList<Integer> modNum = new ArrayList<>();
        for (int num : list) {
            while (num > 0) {
                int temp = num % 10;
                modNum.add(temp);
                num = num / 10;
            }
        }
        return modNum;
    }

    public static int maxResult(ArrayList<Integer> arrayList) {
        int cnt = 0;
        int sum = 0;
        int mul = 1;
        int max = 0;
        int[] maxArr = new int[2];
        for (int y = 0; y < 2; y++) {
            for (int i = 0; i < arrayList.size() / 2; i++) {
                sum += arrayList.get(cnt);
                mul *= arrayList.get(cnt);
                cnt++;
                maxArr[y] = Math.max(sum, mul);
            }
            sum = 0;
            mul = 1;
            max = Math.max(maxArr[0], maxArr[1]);
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. page 정상인지 확인 후 비정상일 경우 -1 return
        int answer = Integer.MAX_VALUE;
        if (validation(pobi) || validation(crong)) {
            return -1;
        }
        // 2. 숫자 하나씩 분해
        ArrayList<Integer> pobiResult = mod(pobi);
        ArrayList<Integer> crongReuslt = mod(crong);
        // 3. pobi 와 crong 의 최대값 구하기
        int pobiMax = maxResult(pobiResult);
        int crongMax = maxResult(crongReuslt);
        // 4. 승부에 따라 0,1,2 return

        return answer;
    }
}

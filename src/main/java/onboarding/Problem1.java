package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int[] arr = {pobi.get(0), pobi.get(1), crong.get(0), crong.get(1)};
        List<Integer> list = new ArrayList<>();

        try {
            if (pobi.get(0) + 1 == pobi.get(1)
                    && crong.get(0) + 1 == crong.get(1)
                    && pobi.size() == 2
                    && crong.size() == 2) {

                for (int i = 0; i < arr.length; i++) {
                    int add = 0;
                    int mul = 1;

                    while (arr[i] > 0) {
                        list.add(arr[i] % 10);
                        arr[i] /= 10;
                    }

                    for (int j = 0; j < list.size(); j++) {
                        add += list.get(j);
                        mul *= list.get(j);
                    }
                    if (add < mul) {
                        arr[i] = mul;
                    } else {
                        arr[i] = add;
                    }
                    list.clear();
                }

                int save = 0;
                int iCount = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > save) {
                        save = arr[i];
                        iCount = i;
                        if (i < arr.length / 2) {
                            answer = 1;
                        } else {
                            answer = 2;
                        }
                    } else if (arr[i] == save && iCount < arr.length / 2 && i > arr.length / 2) {
                        answer = 0;
                    }
                }
            } else answer = -1;
        } catch (Exception e) {
            answer = -1;
        }
        return answer;
    }
}

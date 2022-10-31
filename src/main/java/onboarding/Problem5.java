package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] unit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 큰 화폐 단위 순으로 얻을 수 있는지 확인하며 값 구함
        int unitIdx = 0;
        while(money > 0){
            int nowUnit = unit[unitIdx];
            if(checkUnit(money, nowUnit)){
                int unitAns = money / nowUnit;
                answer.add(unitAns);

                money %= nowUnit * unitAns;
            } else {
                answer.add(0);
            }

            unitIdx++;
        }

        while (answer.size() < 9){
            answer.add(0);
        }

        return answer;
    }

    /**
     * 해당 화폐를 얻을 수 있는지 확인하는 메소드
     * @param money 현재 남은 돈
     * @param unit 현재 화폐 단위
     * @return 해당 화폐를 얻을 수 있으면 true, 없으면 false
     */
    static boolean checkUnit(int money, int unit){
        if(money / unit >= 1){
            return true;
        }

        return false;
    }

}

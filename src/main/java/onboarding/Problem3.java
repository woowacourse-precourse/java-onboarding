package onboarding;

import java.util.Enumeration;

public class Problem3 {
    public static int solution(int number) {
        return getGameResult(number);
    }

    private static boolean isIn369(String string){
        // 3, 6, 9가 있는지 확인해주는 메소드
        int number = Integer.parseInt(string);
        return number == 3 || number == 6 || number == 9;
    }

    private static int getCount(int number){
        // 3, 6, 9의 개수를 세주는 메소드
        String string = String.valueOf(number);
        int count = 0;
        for(String s : string.split("")){
            if (isIn369(s)){
                count += 1;
            }
        }

        return count;
    }

    private static int getGameResult(int number) {
        // 손뼉을 몇 번 치는지 구하는 메소드
        int totalCount = 0;
        for (int i = 1; i < number + 1; i++) {
            totalCount += getCount(i);
        }

        return totalCount;
    }
}

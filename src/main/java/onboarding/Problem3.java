package onboarding;


/**
 * [ Game369 ]
 *  - is_369(int num) = 0이 아니고 3으로 나눈 나머지가 0이면 1을 반환 나머지는 0을 반환
 *  - find_all_369(int num) = num 의 각 자리 수에 3,6,9가 총 몇개 있는지 반환
 *  - get_total_369_one_to_limit(int limit) = 1부터 limit 까지의 숫자에 포함된 총 369의 갯수 반환
 */
public class Problem3 {
    public static int solution(int number) {
        Game369 game369 = new Game369();
        return game369.get_total_369_one_to_limit(number);
    }
}

class Game369 {
    private int is_369(int num) {
        if (num != 0 && num % 3 == 0)
            return 1;
        return 0;
    }

    private int find_all_369(int num) {
        int count = 0;
        while (num != 0) {
            count += is_369(num % 10);
            num /= 10;
        }
        return count;
    }

    public int get_total_369_one_to_limit(int limit) {
        int total = 0;
        for (int i = 1; i <= limit; i++) {
            total += find_all_369(i);
        }
        return total;
    }
}
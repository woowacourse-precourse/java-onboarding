package onboarding;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) clapCount
 *          : number(int)를 인수로 받았을 때, 1부터 number까지 손뼉쳐야하는 횟수를 계산해 반환
 *            1부터 number까지의 수를 돌며 수에 포함된 3, 6, 9의 수만큼 손뼉치는 횟수를 더한다.
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = clapCount(number);
        return answer;
    }


    public static int clapCount(int number){
        int count = 0;

        for (int i = 1; i <= number ; i++){
            int index = i;

            // 1부터 number까지의 수의 각 자리가 3, 6, 9 중의 하나인지를 체크하고, 만약 그렇다면 count를 1씩 높인다.
            while (index != 0){
                int check = index % 10;

                if (check == 3 || check == 6 || check == 9){
                    count++;
                }

                index /= 10;
            }
        }

        return count;
    }
}

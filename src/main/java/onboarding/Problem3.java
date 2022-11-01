package onboarding;

/*
 *
 * Class : Problem 3
 *
 * Date : 2022.10.30
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. number을 입력받는다.
 * 2. 1부터 number까지 수를 탐색한다.
 * 3. 해당 숫자에 3, 6, 9의 개수만큼 count에 더한다.
 * 4. 탐색을 모두 마치면 number까지 손뼉을 몇 번 쳐야 하는지를 출력한다.
 *
 * */


public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count = 0;
        int findNumber = 0;
        for(int i = 1; i < number + 1; i++){
            findNumber = i;
            while(findNumber > 0){
                if(findNumber % 10 == 3 || findNumber % 10 == 6 || findNumber % 10 == 9)
                    count++;
                findNumber = findNumber / 10;
            }
        }
        answer = count;
        return answer;
    }
}

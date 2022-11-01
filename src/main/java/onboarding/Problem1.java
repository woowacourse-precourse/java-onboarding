package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        int maxPobi = listMax(pobi);
        //예외사항
        if(maxPobi==0) return answer;

        int maxCrong = listMax(crong);
        //예외사항
        if(maxCrong==0) return answer;

        if(maxPobi > maxCrong) answer = 1;
        else if(maxPobi < maxCrong) answer = 2;
        else answer = 0;

        return answer;
    }

    //최댓값을 구한다.
    public static int listMax(List<Integer> list){
        int listMax = 0;

        //예외사항(양쪽 페이지가 아닌 경우, 왼쪽-홀수&오른쪽-짝수 아닌 경우, 1 이하 400 이상인 경우)
        if(list.get(0) != list.get(1)-1 |
                list.get(0)%2 != 1 | list.get(1)%2 != 0 |
                list.get(0) <= 1 | list.get(1) >= 400)
            return listMax;

        for(int num : list) {
            int sum;
            int multiple;

            if(num >= 100) {
                sum = num / 100 + num / 10 % 10 + num % 10;
                multiple = (num / 100) * (num / 10 % 10) * (num % 10);
            } else {
                sum = num / 10 % 10 + num % 10;
                multiple = (num / 10 % 10) * (num % 10);
            }
            int max = Math.max(sum, multiple);
            listMax = (listMax > max)? listMax : max;
        }
        return listMax;
    }

}
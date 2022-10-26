package onboarding;

import java.util.List;
/*
1. 책을 임의로 펼친다.
2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
final return:
 포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때,
 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

prohibition:
 pobi와 crong의 길이는 2이다.
 pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다

 */
class Problem1 {
    // 계산을 위한 메소드 선언
    public static int add_page(int page){
        int sol=0;
        String n = Integer.toString(page);
        for(int i=0;i<n.length();i++){
            sol += Integer.parseInt(n.substring(i,i+1));
        }
        return sol;
    }
    public static int mul_page(int page){
        int sol=1;
        String n = Integer.toString(page);
        for(int i=0;i<n.length();i++){
            sol *= Integer.parseInt(n.substring(i,i+1));
        }
        return sol;
    }
    public static int calculate_return_biggest(int page){
        int l_page = page;
        int r_page = page+1; //왼쪽페이지 +1
        // 상식적으로 오른쪽 페이지가 왼쪽 페이지보다 더한값이 더 크다
        return Math.max(add_page(r_page),Math.max(mul_page(r_page),mul_page(l_page)));
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외사항
        if((pobi.get(0)+1 != pobi.get(1)) || (crong.get(0)+1 != crong.get(1))){
            return -1;
        }
        if((pobi.size()!=2) || (crong.size()!=2)){
            return -1;
        }
        // 문제풀이
        int pobi_Max = calculate_return_biggest(pobi.get(0));
        int crong_Max = calculate_return_biggest(crong.get(0));

        int answer = Integer.MAX_VALUE;
        if (pobi_Max == crong_Max) answer = 0;
        else if (pobi_Max > crong_Max) answer = 1;
        else if (pobi_Max < crong_Max) answer = 2;
        else answer = -1;

        return answer;
    }
}
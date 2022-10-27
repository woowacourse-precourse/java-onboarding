package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int pobiPage = Integer.parseInt(br.readLine());
       // int crongPage = Integer.parseInt(br.readLine());

        StringTokenizer pobi = new StringTokenizer(br.readLine(), " ,");
        StringTokenizer crong = new StringTokenizer(br.readLine(), " ,");
        int pobiR = Integer.parseInt(pobi.nextToken());
        int pobiL = Integer.parseInt(pobi.nextToken());
        int crongR = Integer.parseInt(crong.nextToken());
        int crongL = Integer.parseInt(crong.nextToken());
    }
}


/*
 * 랜덤번호 2~399
 * 나온번호 올수짝수 구분 후 홀수 +1 짝수 -1
 * 나온 두 수 *페이지 번호의 각 자리 숫자를 모두 더함 || 모두 곱해 가장 큰 수를 구한다.
 * 더하거나 곱한 수 큰수로 비교
 * 포비 win = 1, 크롱 win = 2, 무승부 = 0, 각 페이지 차가 1이 아니면 -1 ex) 99,102 = -1
 */
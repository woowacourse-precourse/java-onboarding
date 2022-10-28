package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


// 정확한 입력이 들어왔는지 확인하기 1. 포비와 크롱이 2개의 페이지값을 가지나
        if(pobi.size() != 2 || crong.size() != 2){
            System.out.println("1번 이프문 진입");
            return -1;
        }
//2.포비와 크롱이 왼쪽페이지가 오른쪽 페이지보다 큰 값을 가지고 있는지 확인
        if(pobi.get(1) - pobi.get(0) < 0 || crong.get(1)-crong.get(0) < 0){
            return -1;
        }
//3.첫페이지이거나 마지막 페이지인지 확인하기
        if(pobi.get(0) <= 0 || pobi.get(1) >= 400 || crong.get(0) <= 0 || crong.get(0) >= 400){
            return -1;
        }
//4.포비와 크롱이 오른쪽은 홀수 페이지 왼쪽은 짝수 페이지를 가지고 있는지 확인
        for(int i = 1; i-1 < pobi.size(); i++ ){
            if(i%2 != pobi.get(i-1) %2){
                return -1;
            }
        }
        for(int i = 1; i-1 < crong.size(); i++ ){
            if(i%2 != crong.get(i-1) %2){
                return -1;
            }
        }
        int[][] pobiData = new int[2][3];
        int[][] crongData = new int[2][3];
        int[] pobiresult = new int[4];
        int[] crongresult = new int[4];
//크롱과 포비의 페이지 정보를 2차원 배열에 저장 [0][]번지에는 포비 [1][]크롱 [][0]100의 자리수 [][1]10의 자리수 ...
        for(int i = 0; i < 2; i++){
            pobiData[i][0] = pobi.get(i) / 100;
            pobiData[i][1] = (pobi.get(i)-(pobiData[i][0]*100)) / 10;
            pobiData[i][2] = (pobi.get(i)-(pobiData[i][0]*100 + pobiData[i][1]*10));

            crongData[i][0] = crong.get(i) / 100;
            crongData[i][1] = (crong.get(i)-(crongData[i][0]*100)) / 10;
            crongData[i][2] = (crong.get(i)-(crongData[i][0]*100 + crongData[i][1]*10));
        }
//덧셈연산을 배열에 담기
        for(int i = 0; i< pobiData.length; i++){
            int sum = 0;
            sum = pobiData[i][0] + pobiData[i][1] + pobiData[i][2];
            pobiresult[i] = sum;
        }
        for(int i = 0; i< crongData.length; i++) {
            int sum = 0;
            sum = crongData[i][0] + crongData[i][1] + crongData[i][2];
            crongresult[i] = sum;
        }

//곱셉연산을 배열에 담기
        for(int i = 0; i< pobiData.length; i++){
            int sum = 0;
            sum = pobiData[i][0] * pobiData[i][1] * pobiData[i][2];
            pobiresult[i+2] = sum;
        }
        for(int i = 0; i< crongData.length; i++) {
            int sum = 0;
            sum = crongData[i][0] * crongData[i][1] * crongData[i][2];
            crongresult[i+2] = sum;
        }
//최대값을 비교하기!
        int pobiMax = 0;
        int crongMax = 0;

        for(int i = 0; i < pobiresult.length; i++){
            if(pobiMax < pobiresult[i]){
                pobiMax = pobiresult[i];
            }
        }
        for(int i = 0; i < crongresult.length; i++){
            if(crongMax < crongresult[i]){
                crongMax = crongresult[i];
            }
        }
        if(pobiMax > crongMax){
            answer = 1;
        }
        else{
            answer = 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem1 a = new Problem1();
        List<Integer> b = new ArrayList<Integer>();
        b.add(0);
        b.add(1);
        List<Integer> c = new ArrayList<Integer>();
        c.add(399);
        c.add(400);

        System.out.print(a.solution(b,c));


    }
}
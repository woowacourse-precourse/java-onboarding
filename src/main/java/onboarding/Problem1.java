package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_result = 0, crong_result = 0;
        if ((pobi.get(0)%2==0 | crong.get(0)%2==0) |    //왼쪽 페이지가 짝수인 경우
            (pobi.get(0)%2==1 && pobi.get(1)!=pobi.get(0)+1) |  //오른쪽 페이지가 왼쪽페이지+1이 아닌 경우
            (crong.get(0)%2==1 && crong.get(1)!=crong.get(0)+1)) return -1; //에러 반환

        for (int i=0; i<2; i++) {            //왼쪽과 오른쪽 페이지를 순서대로 읽어온다.
            String pobi_tmp = Integer.toString(pobi.get(i));
            String crong_tmp = Integer.toString(crong.get(i));
            int pobi_sum = 0, pobi_mul = 1, crong_sum = 0, crong_mul = 1;
            for (int k=0; k<pobi_tmp.length(); k++) pobi_sum+=(pobi_tmp.charAt(k)-'0');
            for (int k=0; k<crong_tmp.length(); k++) crong_sum+=(crong_tmp.charAt(k)-'0');
            for (int k=0; k<pobi_tmp.length(); k++) pobi_mul*=(pobi_tmp.charAt(k)-'0');
            for (int k=0; k<crong_tmp.length(); k++) crong_mul*=(crong_tmp.charAt(k)-'0');
            pobi_result=Math.max(pobi_sum,pobi_mul);    //pobi의 현재 페이지 최대값 저장
            crong_result=Math.max(crong_sum,crong_mul); //crong의 현재 페이지 최대값 저장
        }
        if (pobi_result > crong_result) return 1;  //pobi 승리
        if (pobi_result < crong_result) return 2;  //crong 승리
        return 0;  //무승부
    }
}
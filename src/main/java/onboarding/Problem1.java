package onboarding;

import java.util.List;

class Problem1 {
    public static boolean checkException(List<Integer> pobi, List<Integer> crong) { //에러 반환
        if ((pobi.get(0)%2==0 | crong.get(0)%2==0) |    //왼쪽 페이지가 짝수인 경우
                (pobi.get(0)%2==1 && pobi.get(1)!=pobi.get(0)+1) |  //오른쪽 페이지가 왼쪽페이지+1이 아닌 경우
                (crong.get(0)%2==1 && crong.get(1)!=crong.get(0)+1)) return false; //에러 반환
        return true;
    }

    public static int getScore(Integer page) {
        int result = 0;
        String tmp = Integer.toString(page);
        int _sum = 0, _mul = 1;
        for (int k=0; k<tmp.length(); k++) _sum+=(tmp.charAt(k)-'0');
        for (int k=0; k<tmp.length(); k++) _mul*=(tmp.charAt(k)-'0');
        return Math.max(_sum,_mul);    //pobi의 현재 페이지 최대값 저장
    }

    public static int compareWinner(int pobi, int crong) {
        if (pobi > crong) return 1;  //pobi 승리
        if (pobi < crong) return 2;  //crong 승리
        return 0;  //무승부
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_result = 0, crong_result = 0;

        if (checkException(pobi,crong)) return -1;

        for (int i=0; i<2; i++) {            //왼쪽과 오른쪽 페이지를 순서대로 읽어온다.
            pobi_result=Math.max(pobi_result,getScore(pobi.get(i)));    //pobi의 현재 페이지 최대값 저장
            crong_result=Math.max(crong_result,getScore(crong.get(i))); //crong의 현재 페이지 최대값 저장
        }

        return compareWinner(pobi_result,crong_result);
    }
}
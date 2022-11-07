package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if ((errocheck(pobi)==1) || (errocheck(crong)==1)){
            return -1;
        }
        int pobinum = comparevalue(pobi);  //포비의 최대값
        int crongnum = comparevalue(crong);//크롱의 최대값

        if (pobinum>crongnum){
            answer = 1;
        }
        else if(crongnum>pobinum){
            answer=2;
        }
        else {
            answer = 0;
        }
        return answer;
    }
    public static int errocheck(List<Integer> num) { // 예외 -1 (책 2쪽의 차이가 1이 아닐때)
        //1~400pg가 아닐때
        //num[0]이 홀수고  num[1]이 짝수가 아닐때
        //페이지수가 잘못되었는지 검사
        if (num.get(0)<1 || num.get(0)>400 || num.get(1) <1 || num.get(1)>400){
            return 1;
        }
        if(num.get(0) % 2 == 0 || num.get(1) %2 == 1){
            return 1;
        }
        if (num.get(1)- num.get(0) != 1) {
            return 1;
        }
        return  0;  //올바르면 0반환
    }
    public static int sum(int [] num) {
        int answer= 0;
        for (int i=0; i<num.length;i++) {
            answer+=num[i];
        }
        return answer;
    }
    public static int multiple(int[] num) {
        int answer = 1;
        for (int i=0; i<num.length;i++) {
            answer*=num[i];
        }
        return answer;
    }
    public static int[] parseNum(int num) { 	// 한자리수 씩 파싱하는 함수
        int len = Integer.toString(num).length();  //자릿수 검사하기
        int []tmpnum = new int[len];
        for(int i=0;i<len; i++) { //역순으로 저장됨
            tmpnum[i]= num%10;
            num /=10;
        }
        int tmp=0;
        for (int i=0;i<len/2;i++) { // 다시 역순으로 뒤집기
            tmp = tmpnum[i];
            tmpnum[i] = tmpnum[len-1-i];
            tmpnum[len-1-i] = tmp;
        }
        return tmpnum;
    }
    public static int comparevalue(List<Integer> num) { // 두값 비교하는 함수
        int max = -1;
        int sumtmp= 0;
        int multmp=0;
        for (int i = 0 ; i<2;i++) {
            sumtmp = sum(parseNum(num.get(i)));
            multmp =multiple(parseNum(num.get(i)));
            if ((sumtmp<multmp) && (max<multmp)) {
                max = multmp;
            }
            else  {
                max = sumtmp;
            }
        }
        return max;
    }
}
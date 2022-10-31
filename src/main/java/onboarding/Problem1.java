package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;             
        int pobiFirstNums = pobi.get(0); // 첫 번째 포비의 수
        int pobiSecondNums = pobi.get(1); // 두 번째 포비의 수
        int crongFirstNums = crong.get(0); // 첫 번째 크롱의 수
        int crongSecondNums = crong.get(1); // 두 번째 크롱의 수        
        int pobiFinalScore=0; // 포비의 가장 큰 수
        int crongFinalScore=0; // 크롱의 가장 큰 수
        int sum=0, multi=0;  // 두 수의 합산, 곱셈
        if(pobiFirstNums>=100) { // 3자리수
        	int first = pobiFirstNums/100;
        	int second = pobiFirstNums%100/10;
        	int third = pobiFirstNums%10;
        	sum=first+second+third;
        	multi=first*second*third;
        	System.out.println(first+","+second+","+third);
        }else if(pobiFirstNums>=10) { // 2자리수
        	int first = pobiFirstNums%100/10;
        	int second = pobiFirstNums%10;
        	sum=first+second;
        	multi=first*second;
        	System.out.println(first+","+second);
        }else { // 1자리수
        	int first = pobiFirstNums%10;
        	sum=first;
        	multi=first;
        	System.out.println(first);
        }
        answer=Math.max(sum, multi); // 합산과 곱셈의 가장 큰수
        if(pobiSecondNums>=100) { // 두번째 포비의 수 위와 같은 로직
        	int first = pobiSecondNums/100;
        	int second = pobiSecondNums%100/10;
        	int third = pobiSecondNums%10;
        	sum=first+second+third;
        	multi=first*second*third;
        	System.out.println(first+","+second+","+third);
        }else if(pobiSecondNums>=10) {
        	int first = pobiSecondNums%100/10;
        	int second = pobiSecondNums%10;
        	sum=first+second;
        	multi=first*second;
        	System.out.println(first+","+second);
        }else {
        	int first = pobiSecondNums%10;
        	sum=first;
        	multi=first;
        	System.out.println(first);
        }
        answer=Math.max(sum, multi);
        pobiFinalScore=answer; // 포비의 가장 큰 수
        /*
         * 아래는 위와 같은 크롱 로직
         */
        if(crongFirstNums>=100) { // 3자리수
        	int first = crongFirstNums/100;
        	int second = crongFirstNums%100/10;
        	int third = crongFirstNums%10;
        	sum=first+second+third;
        	multi=first*second*third;
        	System.out.println(first+","+second+","+third);
        }else if(crongFirstNums>=10) { // 2자리수
        	int first = crongFirstNums%100/10;
        	int second = crongFirstNums%10;
        	sum=first+second;
        	multi=first*second;
        	System.out.println(first+","+second);
        }else { // 1자리수
        	int first = crongFirstNums%10;
        	sum=first;
        	multi=first;
        	System.out.println(first);
        }
        answer=Math.max(sum, multi); // 합산과 곱셈의 가장 큰수
        if(crongSecondNums>=100) { // 두번째 크롱의 수 위와 같은 로직
        	int first = crongSecondNums/100;
        	int second = crongSecondNums%100/10;
        	int third = crongSecondNums%10;
        	sum=first+second+third;
        	multi=first*second*third;
        	System.out.println(first+","+second+","+third);
        }else if(crongSecondNums>=10) {
        	int first = crongSecondNums%100/10;
        	int second = crongSecondNums%10;
        	sum=first+second;
        	multi=first*second;
        	System.out.println(first+","+second);
        }else {
        	int first = crongSecondNums%10;
        	sum=first;
        	multi=first;
        	System.out.println(first);
        }
        answer=Math.max(sum, multi);
        crongFinalScore=answer; // 크롱의 가장 큰 수
        System.out.println("포비:"+pobiFinalScore+" / 크롱:"+crongFinalScore);
        if(pobiFinalScore==crongFinalScore) answer=0;
        else if(pobiFinalScore<crongFinalScore) answer=2;
        else if(pobiFinalScore>crongFinalScore) answer=1;
        else answer=-1;
		return answer;        
    }
}
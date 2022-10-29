package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외 부분
        if(pobi.get(0)<=1||pobi.get(1)<=1||pobi.get(0)>=400||pobi.get(1)>=400)  //맨 앞(1) 뒷면(400) 포함 ,0~400이외 시 예외
            return -1;
        if(crong.get(0)<=1||crong.get(1)<=1||crong.get(0)>=400||crong.get(1)>=400)
            return -1;
        if(pobi.get(1)-pobi.get(0)!= 1 || crong.get(1)- crong.get(0)!=1)
            return -1;

        //변수선언
        List<Integer> eachnum; //숫자의 각 자리 수
        int pagenum; //왼쪽 페이지 수 저장용 변수
        int numadd; //각 숫자 덧셈시 사용
        int nummult; //각 숫자 곱셈시 사용
        int pobiscore = 0; //점수 계산시 사용
        int crongscore = 0;


        //pobi의 왼쪽 페이지 가장 큰 값 구하기
        eachnum = new ArrayList<>();
        numadd=0;
        nummult=1;
        pagenum = pobi.get(0);

        while(pagenum>0) {
            eachnum.add(pagenum % 10);
            pagenum /= 10;
        }

        for(int i =0; i<eachnum.size(); i++) {
            numadd += eachnum.get(i);
            nummult *= eachnum.get(i);
        }

        if(numadd>=nummult)
            pobiscore=numadd;
        if(numadd<nummult)
            pobiscore=nummult;

        //pobi의 오른쪽 페이지 가장 큰 값 구하기
        eachnum = new ArrayList<>();
        numadd=0;
        nummult=1;
        pagenum = pobi.get(1);

        while(pagenum>0) {
            eachnum.add(pagenum % 10);
            pagenum /= 10;
        }

        for(int i =0; i<eachnum.size(); i++) {
            numadd += eachnum.get(i);
            nummult *= eachnum.get(i);
        }

        if(numadd>=nummult && numadd>pobiscore)
            pobiscore=numadd;

        if(numadd<nummult && nummult>pobiscore)
            pobiscore=nummult;

        //crong의  왼쪽 페이지 가장 큰 값 구하기
        eachnum = new ArrayList<>();
        numadd=0;
        nummult=1;
        pagenum = crong.get(0);

        while(pagenum>0) {
            eachnum.add(pagenum % 10);
            pagenum /= 10;
        }

        for(int i =0; i<eachnum.size(); i++) {
            numadd += eachnum.get(i);
            nummult *= eachnum.get(i);
        }

        if(numadd>=nummult)
            crongscore=numadd;
        if(numadd<nummult)
            crongscore=nummult;

        //crong의  오른쪽 페이지 가장 큰 값 구하기
        eachnum = new ArrayList<>();
        numadd=0;
        nummult=1;
        pagenum = crong.get(1);

        while(pagenum>0) {
            eachnum.add(pagenum % 10);
            pagenum /= 10;
        }

        for(int i =0; i<eachnum.size(); i++) {
            numadd += eachnum.get(i);
            nummult *= eachnum.get(i);
        }

        if(numadd>=nummult && numadd>crongscore)
            crongscore=numadd;

        if(numadd<nummult && nummult>crongscore)
            crongscore=nummult;


        int answer = Integer.MAX_VALUE;

        if(pobiscore>crongscore)
            answer = 1;
        if(pobiscore<crongscore)
            answer = 2;
        if(pobiscore==crongscore)
            answer = 0;
        return answer;
    }
}


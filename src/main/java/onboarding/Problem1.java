package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        myfunc01 mf= new myfunc01(); // 메소드 임포트
        return answer;
    }
    public static class myfunc01 {
        // 분리가 된 자릿수를 더하는 기능
        int sum(List<Integer> nums) {
            return (int) nums.stream().reduce((x, y) -> x + y).stream().toArray()[0];
        }
        // 분리가 된 자릿수를 곱하는 기능
        int multi(List<Integer> nums){
            return (int) nums.stream().reduce((x,y)->x*y).stream().toArray()[0];
        }
        // 한 쪽 페이지의 숫자에 대하여 자릿수를 하나씩 리스트에 집어넣어 리턴하는 기능
        List<Integer> divPage(Integer pages){
            String s=Integer.toString(pages);
            List<Integer> result=new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                result.add(Integer.parseInt(s.substring(i,i+1))); // 자릿수를 하나씩 리스트에 추가
            }
            return result;
        }
        // 각자의 점수 계산
        int cal_score(List<Integer> user,myfunc01 mf ,int rep){
            for (int i = 0; i < 2; i++) { // 포비
                List<Integer> tmp = mf.divPage(user.get(i));
                int a=mf.sum(tmp);
                int b=mf.multi(tmp);
                if(a>=b){ // 합한 것이 더 클 경우
                    if(rep<a) rep=a;
                }else { // 곱한 것이 더 클경우
                    if(rep<b) rep=b;
                }
            }
            return rep;
        }

    }
}
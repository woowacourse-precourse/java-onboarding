package onboarding;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(97,98),Arrays.asList(197,198)));
        System.out.println(solution(Arrays.asList(131,132),Arrays.asList(211,212)));
        System.out.println(solution(Arrays.asList(99,102),Arrays.asList(211,212)));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        //예외 발생
        if (exception(pobi) || exception(crong)) return -1;

        int cMax, pMax; // 포비와 크롱의 최댓값을 담을 변수

        pMax = Math.max(maxMulAdd(pobi.get(0)),maxMulAdd(pobi.get(1))); // 포비의 최댓값
        cMax = Math.max(maxMulAdd(crong.get(0)),maxMulAdd(crong.get(1))); // 크롱의 최댓값

        if (cMax == pMax) answer = 0; // 값이 같다면 0
        else answer = (pMax > cMax) ? 1 : 2; // 포비가 크면 1 크롱이 크면 2

        return answer; //
    }

    public static int maxMulAdd(int num){ // 모든 자리수를 더한 값과 곱합 값을 비교하는 함수
        int add = 0, mul = 1; // 변수 초기화
        while (num > 0){ // 넘이 0일 때까지
            add += num % 10; // 1의 자리를 더 해줌
            mul *= num % 10; // 1의 자리 곱 해줌
            num /= 10; // 넘 값을 줄인다
        }
        return Math.max(add, mul); // 더 큰 값
    }
    public static boolean exception(List<Integer> array){
        if (array.size() != 2) return true; // 리스트 사이즈가 2인지
        if (array.get(0) < 0 || array.get(1) > 400) return true; //페이지는 1~400
        if (array.get(0) % 2 == 0 || array.get(1) % 2 == 1) return true; // 왼쪽은 홀수, 오른쪽은 짝수
        return array.get(1) - array.get(0) != 1; //오른쪽 페이지 - 왼쪽 페이지 = 1
    }
}
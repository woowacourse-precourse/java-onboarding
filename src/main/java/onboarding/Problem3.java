package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

/* 구현 로직
* 입력받은 숫자까지 반복문을 돌린다.
* 숫자를 각 자리로 쪼개서 3,6,9의 갯수를 찾는다.
* 모든 값을 더한 것이 답이 된다.
* */

/* 필요 기능
* 1. 입력받은 숫자 안에 3,6,9의 갯수를 세는 함수
*   1-2. 입력 받은 숫자를 숫자 리스트 형태로 반환하는 함수
*   1-3. 숫자 리스트 안에 3,6,9가 몇개 있는지 반환하는 함수
* */

/*
* Problem1에서 사용한 changeIntToIntList 함수를 재활용할 수 있을 것 같다.
* Util이라는 클래스를 만들어서 재활용해보자.
* */
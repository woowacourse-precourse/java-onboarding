package onboarding;

// 리스트 타입을 사용하기 모듈 임포트
import java.util.List;

// 문제 1 클래스
class Problem1 {

    // 2,3 왼쪽, 오른쪽 페이지 연산 중 큰 수 찾기.
    static int getPageCalc(int page)
    {
        int resultSum = 0;
        int resultMul = 1;

        // 각 자리 숫자를 하나씩 연산 수행
        while((page/10) != 0)
        {
            resultSum += page%10;
            resultMul *= page%10;

            page /= 10;

            if((page/10) == 0)
            {
                resultSum += page;
                resultMul *= page;
            }
        }
    
        // 덧셈, 곱셉 결과 중 큰 수 반환
        if(resultSum >= resultMul)
            return resultSum;
        else
            return resultMul;
    }

    // 4. 가장 큰 수를 나의 점수로 하기.
    static int getScoreCalc(int leftPage, int rightPage)
    {
        if(leftPage >= rightPage)
            return leftPage;
        else
            return rightPage;
    }

    // 5-1. 점수를 비교하여 승부 가리기.
    static int getGameResult(int pobiScore, int crongScore)
    {
        if(pobiScore > crongScore)
            return 1;
        else if(pobiScore == crongScore)
            return 0;
        else
            return 2;
    }

    // 1. 책을 임의로 펼친다.
    // 포비와 크롱의 임의의 책 페이지 받아오기
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 왼쪽 페이지 연산
        int leftPageP = getPageCalc(pobi.get(0));
        int leftPageC = getPageCalc(crong.get(0));

        // 오른쪽 페이지 연산
        int rightPageP = getPageCalc(pobi.get(1));
        int rightPageC = getPageCalc(crong.get(1));

        // 내 점수 구하기 연산
        int pobiScore = getScoreCalc(leftPageP,rightPageP);
        int crongScore = getScoreCalc(leftPageC,rightPageC);

        // 게임 승부 연산
        answer = getGameResult(pobiScore,crongScore);

        // 게임 결과 확인
        System.out.println(answer);

        return answer;
    }
}

// 프로그래밍 요구 사항
// 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기
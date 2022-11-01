package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // max: 현재 페이지의 자리수로 계산한 최대값
        // sum: 합 계산을 위한 변수, mul: 곱 계산을 위한 변수
        int max, sum, mul;
        // isError: 조건에 어긋나는 입력이 주어졌는지 확인하는 변수
        boolean isError = false;
        // nums: 페이지를 자리수로 나눠서 저장하는 리스트
        // maxs: pobi와 crong의 최대값을 저장하는 리스트
        List<Integer> nums, maxs;
        // inputs: pobi와 crong을 리스트에 넣어서 반복문을 돌리기 위한 리스트
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(pobi);
        inputs.add(crong);

        maxs = new ArrayList<>();
        for(List<Integer> input: inputs) {
            // 조건에 어긋나는 입력이 주어지면 isError를 true로 만들고 반복 종료
            if(input.size() != 2 ||
                input.get(0) < 0 || input.get(1) > 400 ||
                input.get(1) - input.get(0) != 1 ||
                input.get(0) % 2 == 0) {
                isError = true;
                break;
            }

            max = 0;
            for(int pageNum: input) {
                nums = new ArrayList<>();

                // 페이지 번호에서 각 자리수를 얻어서 nums 리스트에 저장
                while(pageNum != 0) {
                    nums.add(pageNum % 10);
                    pageNum /= 10;
                }

                // nums에 저장된 숫자들의 합을 계산 및 최대값 갱신
                sum = 0;
                for(int num: nums)
                    sum += num;
                if(max < sum)
                    max = sum;

                // nums에 저장된 숫자들의 곱을 계산 및 최대값 갱신
                mul = 1;
                for(int num: nums)
                    mul *= num;
                if(max < mul)
                    max = mul;
            }

            // 합과 곱 중에서 최대값을 maxs 리스트에 저장
            maxs.add(max);
        }

        // 잘못된 입력이 있을 경우 -1을 반환
        if(isError) {
            answer = -1;
        } else {
            int pobiMax = maxs.get(0);
            int crongMax = maxs.get(1);

            // pobi의 최대값 > crong의 최대값 => 1 반환
            // pobi의 최대값 < crong의 최대값 => 2 반환
            // pobi의 최대값 = crong의 최대값 => 0 반환
            if(pobiMax > crongMax)
                answer = 1;
            else if (pobiMax < crongMax)
                answer = 2;
            else
                answer = 0;
        }

        return answer;
    }
}
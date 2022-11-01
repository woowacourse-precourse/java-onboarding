package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 포비와 크롱의 왼쪽 페이지의 합과 곱 중 큰 값이 max에 들어간다
        int pobi_max = getMax(pobi.get(0));
        int crong_max = getMax(crong.get(0));

        // 포비와 크롱의 오른쪽 페이지와 현재 max 값을 비교해서 더 큰 숫자가 max 값에 저장
        if (getMax(pobi.get(1)) > pobi_max)
            pobi_max = getMax(pobi.get(1));
        if (getMax(crong.get(1)) > crong_max)
            crong_max = getMax(crong.get(1));

        // 포비가 크면 1을 크롱이 크면 -1을 비기면 0을 출력한다
        if (pobi_max > crong_max)
            answer = 1;

        if (pobi_max < crong_max)
            answer = -1;

        if (pobi_max == crong_max)
            answer = 0;

        // 첫 페이지, 마지막 페이지 예외 처리
        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400)
            return -1;
        // 페이지가 제대로 입력되지 않을 때 예외 처리
        if (pobi.get(1) % 2 != 0  || pobi.get(0) % 2 != 1 || crong.get(1) % 2 != 0 || crong.get(0) % 2 != 1)
            return -1;
        // pobi와 crong의 길이가 2가 아니면 에외 처리
        if (pobi.size() != 2 || crong.size() != 2)
            return -1;

        return answer;
    }

    public static int getMax(int i) {
        int[] arr = new int[3];

        if (i >= 100) {
            arr[0] = i / 100;
            arr[1] = i % 100 / 10;
            arr[2] = i % 10;

            return (arr[0] + arr[1] + arr[2] > arr[0] * arr[1] * arr[2]) ?
                    arr[0] + arr[1] + arr[2] : arr[0] * arr[1] * arr[2];
        }

        else if (i >= 10 && i < 100) {
            arr[0] = i / 10;
            arr[1] = i % 10;

            return (arr[0] + arr[1] > arr[0] * arr[1]) ?
                    arr[0] + arr[1] : arr[0] * arr[1];
        }

        else {
            return i;
        }
    }
}
package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 기능목록
// 1. 제한사항으로 왼쪾은 홀수, 오른쪽은 짝수, 연속된 숫자만 올수 있게 한다.
// 2. 포비와 크롱의 배열의 첫번째 숫자와 두번째 숫자를 자릿수별로 쪼갠다. ex) [97,98] -> [9,7] [9,8]
// 3. 자릿수 별로 나누어진 수들의 덧셈연산을 수행한다.  ex) 9+7, 9+8
// 4. 자릿수 별로 나누어진 수들의 곱셈연산을 수행한다. ex) 9*7, 9*8
// 5. 덧셈연산을 한 수 2개와 곱셈을 한 수 2개중 가장 큰 수를 찾는다.
// 6. 가장 큰 수끼리 비교해 포비가 이기면 1, 크롱이 이기면 2, 무승부면 0, 제한사항에서 벗어나면 -1을 출력값으로 준다.


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int[] pobi_arr = new int[4]; // 포비의 합과 곱을 담게 될 리스트. 왼 오 왼 오 총 4개가 나옴
        int[] crong_arr = new int[4]; // 크롱의 합과 곱을 담게 될 리스트. 왼 오 왼 오 총 4개가 나옴

        pobi_arr[1] = 1; //곱셈연산을 수행하기 위해 곱셈연산을 수행한 값이 들어올 자리는 값을 1로 초기화 한다.
        pobi_arr[3] = 1;
        crong_arr[1] = 1;
        crong_arr[3] = 1;

        int pobi_l = pobi.get(0);
        int pobi_r = pobi.get(1);
        int crong_l = crong.get(0);
        int crong_r = crong.get(1);
        ArrayList<Integer> arr1 = new ArrayList<>(); //pobi의 왼쪽 숫자의 자리값들이 들어감
        ArrayList<Integer> arr2 = new ArrayList<>(); //pobi의 오른쪽 숫자의 자리값들이 들어감
        ArrayList<Integer> arr3 = new ArrayList<>(); //crong의 왼쪽 숫자의 자리값들이 들어감
        ArrayList<Integer> arr4 = new ArrayList<>(); //crong의 오른쪽 숫자의 자리값들이 들어감

        int result = 0;
        int pobi_val = pobi_r-pobi_l; //연속적인 숫자의 차이는 1 이므로 연속된 숫자인지 검증할때 사용한다.
        int crong_val = crong_r-crong_l;

        if (pobi_l%2==1 & pobi_r%2==0 & crong_l%2==1 & crong_r%2==0 & pobi_val==1 & crong_val==1) {

            //포비의 왼쪽 숫자를 자릿수로 나누고 arr1에 넣어준다.
            while (pobi_l > 0) {
                arr1.add(pobi_l % 10);
                pobi_l = pobi_l / 10;
            }

            // 포비의 오른쪽 숫자를 자릿수로 나누고 arr2에 넣어준다
            while (pobi_r > 0) {
                arr2.add(pobi_r % 10);
                pobi_r = pobi_r / 10;
            }

            for (int i = 0; i < arr1.toArray().length; i++) {
                pobi_arr[0] = pobi_arr[0] + arr1.get(i); // 포비의 쪼갠 왼쪽 숫자들의 합
            }

            for (int i = 0; i < arr1.toArray().length; i++) {
                pobi_arr[1] = pobi_arr[1] * arr1.get(i); // 포비의 왼쪽 숫자 들의 곱하기
            }

            for (int i = 0; i < arr2.toArray().length; i++) {
                pobi_arr[2] = pobi_arr[2] + arr2.get(i); // 포비의 쪼갠 오른쪽 숫자들의 합
            }

            for (int i = 0; i < arr2.toArray().length; i++) {
                pobi_arr[3] =  pobi_arr[3] * arr2.get(i); // 포비의 오른쪽 숫자 들의 곱하기
            }

            //크롱의 왼쪽 숫자를 자릿수로 나누고 arr3에 넣어준다.
            while (crong_l > 0) {
                arr3.add(crong_l % 10);
                crong_l = crong_l / 10;
            }

            // 크롱의 오른쪽 숫자를 자릿수로 나누고 arr4에 넣어준다.
            while (crong_r > 0) {
                arr4.add(crong_r % 10);
                crong_r = crong_r / 10;
            }

            for (int i = 0; i < arr3.toArray().length; i++) {
                crong_arr[0] = crong_arr[0] + arr3.get(i); // 크롱의 쪼갠 왼쪽 숫자들의 합
            }

            for (int i = 0; i < arr3.toArray().length; i++) {
                crong_arr[1] = crong_arr[1] * arr3.get(i); // 왼쪽 숫자 들의 곱하기
            }

            for (int i = 0; i < arr4.toArray().length; i++) {
                crong_arr[2] = crong_arr[2] + arr4.get(i); // 크롱의 쪼갠 오른쪽 숫자들의 합
            }

            for (int i = 0; i < arr4.toArray().length; i++) {
                crong_arr[3] =crong_arr[3] * arr4.get(i); // 크롱의 오른쪽 숫자 들의 곱하기
            }

            Arrays.sort(pobi_arr); //정렬로 큰 값이 가장 뒤로 가게 함
            Arrays.sort(crong_arr);

            if (pobi_arr[3] > crong_arr[3]) {
                result = 1;
            } else if (pobi_arr[3] < crong_arr[3]) {
                result = 2;
            }

        } else {
            result = -1;
        }

        return result;
    }
}
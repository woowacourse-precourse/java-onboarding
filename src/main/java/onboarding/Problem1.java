package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 주어진 리스트에서 왼쪽과 오른쪽을 분할
// 분할된 왼쪽 리스트를 자릿수로 분할해서 리스트에 넣음 -> 리스트에서 가장 큰 수만 사용
// 왼쪽 숫자의 합과 곱을 담은 리스트, 오른쪽 숫자의 합과 곱을 담은 리스트 필요
// 예외사항 : 1~400까지여야만 함. 왼쪽수가 홀수 오른쪽수가 짞수여야함,

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int[] pobi_arr = new int[4]; // 포비의 합과 곱을 담게 될 리스트. 왼 오 왼 오 총 4개가 나옴
        int[] crong_arr = new int[4]; // 왼쪽 합과 곱을 담게 될 리스트

        pobi_arr[1] = 1;
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
        int pobi_val = pobi_r-pobi_l;
        int crong_val = crong_r-crong_l;

        if (pobi_l%2==1 & pobi_r%2==0 & crong_l%2==1 & crong_r%2==0 & pobi_val==1 & crong_val==1) {
            //포비의 왼쪽 숫자를 자릿수로 나누고 arr1에 넣어준다. 9, 7
            while (pobi_l > 0) {
                arr1.add(pobi_l % 10);
                pobi_l = pobi_l / 10;
            }

            // 포비의 오른쪽 숫자를 자릿수로 나누고 arr2에 넣어준다 9, 8
            while (pobi_r > 0) {
                arr2.add(pobi_r % 10);
                pobi_r = pobi_r / 10;
            }

            for (int i = 0; i < arr1.toArray().length; i++) {
                pobi_arr[0] = pobi_arr[0] + arr1.get(i); // 포비의 쪼갠 왼쪽 숫자들의 합 9+7
            }

            for (int i = 0; i < arr1.toArray().length; i++) {
                pobi_arr[1] = pobi_arr[1] * arr1.get(i); // 왼쪽 숫자 들의 곱하기 9*7
            }

            for (int i = 0; i < arr2.toArray().length; i++) {
                pobi_arr[2] = pobi_arr[2] + arr2.get(i); // 포비의 쪼갠 오른쪽 숫자들의 합 9+8
            }

            for (int i = 0; i < arr2.toArray().length; i++) {
                pobi_arr[3] =  pobi_arr[3] * arr2.get(i); // 왼쪽 숫자 들의 곱하기 9*8
            }

            //크롱의 왼쪽 숫자를 자릿수로 나누고 arr3에 넣어준다. 1 9 7
            while (crong_l > 0) {
                arr3.add(crong_l % 10);
                crong_l = crong_l / 10;
            }

            // 크롱의 오른쪽 숫자를 자릿수로 나누고 arr4에 넣어준다 1 9 8
            while (crong_r > 0) {
                arr4.add(crong_r % 10);
                crong_r = crong_r / 10;
            }

            for (int i = 0; i < arr3.toArray().length; i++) {
                crong_arr[0] = crong_arr[0] + arr3.get(i); // 크롱의 쪼갠 왼쪽 숫자들의 합 1+9+7
            }

            for (int i = 0; i < arr3.toArray().length; i++) {
                crong_arr[1] = crong_arr[1] * arr3.get(i); // 왼쪽 숫자 들의 곱하기
            }

            for (int i = 0; i < arr4.toArray().length; i++) {
                crong_arr[2] = crong_arr[2] + arr4.get(i); // 포비의 쪼갠 오른쪽 숫자들의 합
            }

            for (int i = 0; i < arr4.toArray().length; i++) {
                crong_arr[3] =crong_arr[3] * arr4.get(i); // 왼쪽 숫자 들의 곱하기
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
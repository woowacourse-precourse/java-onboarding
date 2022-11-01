package onboarding;

//5번과제_Jieun1ee
import java.util.ArrayList;
import java.util.Scanner;

public class problem5 {
	public static void main(String[] args) {
		int money = 0; //입력받을 금액의 값
		int money2 = 0; //나눈 값 저장
		int[] devide_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 50000원부터 1원까지 리스트에 저장
		ArrayList<Integer> devide_value = new ArrayList<>(); // 나누고 출력해주는 값 배열
		
		Scanner s = new Scanner(System.in);
		System.out.println("금액을 입력해주세요.(1원부터 1,000,000원까지)"); // 입력
		money = s.nextInt(); //money에 입력값 넣기
		
		if (1 <= money & money <= 1000000) {
			// System.out.println(money); //money 값이 범위 내에 있으면 잘 들어갔는지 확인.
		} else {
			System.out.println("범위 밖의 숫자. 프로그램을 종료합니다.");
		}
		
		// 반복문 돌면서 50000원부터 차례대로 나누기
		for (int i = 0; i < devide_money.length; i++){
			money2 = money / devide_money[i];
			devide_value.add(money2);
			money = money % devide_money[i];
		}
		System.out.print(devide_value);
		s.close();
	}
}

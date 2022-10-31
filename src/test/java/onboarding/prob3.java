package onboarding;

import java.util.Scanner;

public class prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("1���� 10000������ ������ �Է��ϼ���.");
		String num = sc.next();
		int number = Integer.parseInt(num);// �Էº��� int����ȯ
		int a = 0;
		for(int i = 1; i <= number; i++) {
			int x = i % 1000 % 100 % 10; // 1�� �ڸ���
			int y = i % 1000 % 100 / 10; // 10�� �ڸ���
			int xa = i % 1000 / 100; //100�� �ڸ���
			int xaa = i / 1000; //1000�� �ڸ���
			
			if((x == 3 || x == 6 || x == 9) || 
					(y == 3 || y == 6 || y == 9)  || 
					(xa == 3 || xa == 6 || xa == 9) ||
					(xaa == 3 || xaa == 6 || xaa == 9))
			{
//				System.out.print("x" + "  ");
				a++;
			}else {
//				System.out.print(i + "  ");
			}
			if(i%10 == 0) {
//				System.out.println();
			}
		}
		System.out.println(" ");
		System.out.println("sol : " + a);
	}
}

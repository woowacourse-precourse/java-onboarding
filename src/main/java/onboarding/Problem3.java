package onboarding;

import java.util.Scanner;

public class problem3 { 
    public static void main(String[] args) {
        // int number = 0;
        int temp = 0;
        int count = 0;

        Scanner s = new Scanner(System.in);
		System.out.println("1부터 10,000사이의 숫자를 입력해 주세요"); // 입력
		String number = s.next(); //money에 입력값 넣기

        int length = number.length();
        int num = Integer.parseInt(number);
        System.out.println("num");
        System.out.println(num);
        System.out.println("length");
        System.out.println(length);

        while (length > 0) {
            if(num >= 1 & num <= 10000) {
                if (length == 1) {
                    System.out.println("포문을 들어오는가?");
                    for(int i=0; i <= num; i++){
                        if (i == 3 || i == 6 || i == 9) {
                            System.out.println("이거는?");
                            count += 1;
                            System.out.println("count는 왜안돼?");
                            System.out.println(count);
                        }
                    }
                    length--;
                    System.out.println("길이는 줄어드니?");
                    System.out.println(length);
                }
                else {
                    temp = (int) (num / (Math.pow(10, length-1)));
                    System.out.println("도대체 템프는 무ㅓ니");
                    System.out.println(temp);
                // // number를 10^length만큼으로 나눈거
                System.out.println("num이뭐임");
                System.out.println(num);
                    for(int i = 0; i <= num; i++)
				        if (i == 3 || i == 6 || i == 9) {
					        count += 1;
                            System.out.println("temp이후 카운트");
                            System.out.println(count);
				        }

				        num = (int) (num - (temp * (Math.pow(10, length-1))));
                        System.out.println("temp의 num 변화");
                        System.out.println(num);;
				        length--;
                        System.out.println("템프의 렝스");
                        System.out.println(length);
                        }
                    }
            else {
                System.out.println("숫자의 범위를 벗어났습니다.");
                System.exit(0);
            }
        }


        System.out.println("이거는왜");
        System.out.println(count); // 입력
        s.close();
    }
}

package onboarding;

//2번과제_Jieun1ee
// import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class problem2 {
    public static void main(String[] args) {
        Stack<String> st = new Stack<String>();

		Scanner s = new Scanner(System.in);
		System.out.println("해독할 코드 입력해주세요."); // 입력
        String code = s.next(); //해독할 코드를 code에 입력

        for(int i = 0; i < code.length(); i++) {
            st.push(code.substring(i,i+1));
        }
        System.out.println(st);

        for(int i = 0; i < st.size(); i++) {
            int tmp1 = st.search(i);
            int tmp2 = st.search(i + 1);
            if (tmp1 - tmp2 == 1) {
                System.out.println(st.get(i));
            }
        }
        s.close();
    }
}

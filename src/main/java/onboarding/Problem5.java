package onboarding;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();


        int m_5 = (int)(money/50000);
        money = money-(m_5*50000);

        int m_10000 = money/10000;
        money = money - (m_10000 * 10000);

        int m_5000 = money/5000;
        money = money - (m_5000*5000);

        int m_1000 = money/1000;
        money = money - (m_1000*1000);

        int m_500 = money/500;
        money = money - (m_500*500);

        int m_100 = money/100;
        money = money - (m_100*100);

        int m_50 = money/50;
        money = money-(m_50*50);

        int m_10 = money/10;
        money = money-(m_10*10);

        int m_1 = money;

        answer.add(m_5);
        answer.add(m_10000);
        answer.add(m_5000);
        answer.add(m_1000);
        answer.add(m_500);
        answer.add(m_100);
        answer.add(m_50);
        answer.add(m_10);
        answer.add(m_1);

        return answer;
    }
}

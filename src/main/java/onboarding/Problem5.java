package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static void money_changer(int t_money, int index,List<Integer> m_list,List<Integer> ans){
        int now_mkind = m_list.get(index);
        int now_mkind_cnt =t_money/now_mkind;
        int temp = ans.get(index);
        if( now_mkind_cnt>=1 && t_money>=10){
            ans.set(index,ans.get(index)+now_mkind_cnt);
            t_money = t_money % now_mkind;
            money_changer(t_money,index+1,m_list,ans);
        } else if (t_money<10) {
            ans.set(index,ans.get(index)+t_money);
        } else{
            money_changer(t_money,index+1,m_list,ans);
        }
    }
    public static List<Integer> solution(int money) {

        List<Integer> m_kind = List.of(50000,10000,5000,1000,500,100,50,10,1);
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        money_changer(money,0,m_kind,answer);

        return answer;
    }
}

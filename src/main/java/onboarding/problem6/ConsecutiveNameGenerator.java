package onboarding.problem6;

import org.assertj.core.util.Strings;
import org.mockito.internal.util.StringUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConsecutiveNameGenerator {
    private Set<String> set = new HashSet<>();

    // 연속적인 숫자의 기준점
    private static Integer CONTINUOUS_CRITERION_NUMBER = 2;

    // 임시 저장
    private Stack<String> temp = new Stack<>();
    private String name ;
    private ConsecutiveNameGenerator(final String name){
        this.name = name;
        dfs(0);
    };

    private void dfs(int position){
        if(temp.size() >= CONTINUOUS_CRITERION_NUMBER){
            this.set.add(this.stackToString(temp));
        }
        if(position >= name.length()){
            return ;
        }
        temp.push(String.valueOf(name.charAt(position)));
        dfs(position+1);
        temp.clear();
        dfs(position+1);
    }

    private String stackToString(Stack<String> stack){
       StringBuilder stringBuilder = new StringBuilder();
       for(String item : stack){
           stringBuilder.append(item);
       }
       return stringBuilder.toString();
    }

    public static Set<String> generate(String name) {
        var generator = new ConsecutiveNameGenerator(name);
        return generator.set;
    }
}

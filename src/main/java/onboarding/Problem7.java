package onboarding;

import net.bytebuddy.matcher.FilterableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> temp = new ArrayList<>();

        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            temp.add(friends.get(i).get(0));
            temp.add(friends.get(i).get(1));
        }
        for(int i = 0; i < visitors.size(); i++){
            temp.add(visitors.get(i));
        }

        temp = temp.stream().distinct().collect(Collectors.toList());
        Collections.sort(temp);

        List<String> answer = new ArrayList<>();

        Integer[] score = new Integer[temp.size()];
        List<Integer> mirror = new ArrayList<>();

        for(int i = 0; i < temp.size();i++){
            score[i]= 0;
        }

        for(int i = 0; i < temp.size(); i++){
           if(temp.get(i)==user) score[i] = -100000;
        }

        for(int i = 0; i < friends.size(); i++){
            int j = 0;
            if(friends.get(i).get(0)==user){
                for(; j < temp.size(); j++){
                    if(friends.get(i).get(1)==temp.get(j)){
                        score[j] = -1000;
                    }
                }
            }
            else if(friends.get(i).get(1)==user){
                for(j = 0; j < temp.size(); j++){
                    if(friends.get(i).get(0)==temp.get(j)){
                        score[j] = -1000;
                    }
                }
            }
        }

//        for(int i = 0; i < temp.size(); i++){
//            System.out.println(score[i]);
//        }
//        System.out.println("*");

        for(int i = 0; i < temp.size();i++){
            for(int j = 0; j < friends.size();j++){
                if(-1000 == score[temp.indexOf(friends.get(j).get(0))]){
                    score[temp.indexOf(friends.get(j).get(1))]+=10;
                }
                else if( -1000 == score[temp.indexOf(friends.get(j).get(1))]){
                    score[temp.indexOf(friends.get(j).get(0))]+=10;
                }
            }
        }

        for(int i = 0; i < visitors.size();i++){
            score[temp.indexOf(visitors.get(i))] +=1;
        }

        for(int i = 0; i < temp.size(); i++){
            System.out.println(score[i]);
               }


        System.out.println(temp);
        for(int i = 0 ; i < temp.size(); i++){
            mirror.add(i,score[i]);
        }

        Arrays.sort(score,Collections.reverseOrder());

        for(int i = 0; i < mirror.size(); i++){
            int j = 0;
            for(j = 0; j < mirror.size(); j++){
                if(score[i]==mirror.get(j)&&!order.contains(j)){
                    break;
                }
            }
            order.add(i,j);
        }

        System.out.println(order);

        for(int i = 0; i < order.size(); i++){
            if(mirror.get(order.get(i))>0){
                answer.add(temp.get(order.get(i)));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String u = new String();

        List<List<String>> f = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        List<String> temp1 = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        List<String> temp3 = new ArrayList<>();
        List<String> temp4 = new ArrayList<>();
        List<String> temp5 = new ArrayList<>();

        List<String> v = new ArrayList<>();

        u = "mrko";

        temp.add(0,"donut");
        temp.add(1,"andole");
        f.add(0,temp);
        temp1.add(0,"donut");
        temp1.add(1,"jun");
        f.add(1,temp1);
        temp2.add(0,"donut");
        temp2.add(1,"mrko");
        f.add(2,temp2);
        temp3.add(0,"shakevan");
        temp3.add(1,"andole");
        f.add(3,temp3);
        temp4.add(0,"shakevan");
        temp4.add(1,"jun");
        f.add(4,temp4);
        temp5.add(0,"shakevan");
        temp5.add(1,"mrko");
        f.add(5,temp5);

        v.add(0,"bedi");
        v.add(1,"bedi");
        v.add(2,"donut");
        v.add(3,"bedi");
        v.add(4,"shakevan");

//        System.out.println(f);
//        System.out.println(v);

        System.out.println(solution(u,f,v));
    }
}

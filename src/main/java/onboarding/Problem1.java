package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
   public static void main(String[] args) {
      List<Integer> pobi = new ArrayList<>();
      List<Integer> crong = new ArrayList<>();
      
      pobi.add(131);
      pobi.add(132);
      crong.add(211);
      crong.add(212);
      
      System.out.println(solution(pobi,crong));
   }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
       if(pobi.get(0)%2 == 0 || pobi.get(1)%2 == 1 || crong.get(0)%2 == 0 || crong.get(1)%2 == 1) {
         return -1;
      }else if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1) {
         return -1;
      }
      
      int pleftP = plus(pobi.get(0));
      int pleftM = mul(pobi.get(0));
      int prightP = plus(pobi.get(1));
      int prightM = mul(pobi.get(1));
      int cleftP = plus(crong.get(0));
      int cleftM = mul(crong.get(0));
      int crightP = plus(crong.get(1));
      int crightM = mul(crong.get(1));
      
      int pleftB;
      int prightB;
      int cleftB;
      int crightB;
      int p;
      int c;
      int answer;
      
      if(pleftP > pleftM) {
         pleftB = pleftP;
      }else {
         pleftB = pleftM;
      }
      
      if(prightP > prightM) {
         prightB = prightP;
      }else {
         prightB = prightM;
      }
      
      if(cleftP > cleftM) {
         cleftB = cleftP;
      }else {
         cleftB = cleftM;
      }
      
      if(crightP > crightM) {
         crightB = crightP;
      }else {
         crightB = crightM;
      }
      
      if(pleftB > prightB) {
         p = pleftB;
      }else {
         p = prightB;
      }
      
      if(cleftB > crightB) {
         c = cleftB;
      }else {
         c = crightB;
      }
      
      if(p>c) {
         answer = 1;
      }else if(p == c) {
         answer = 0;
      }else {
         answer = 2;
      }
        return answer;
    }
    public static int plus(int a) {
      return a/100 + (a%100/10) + a%10;
   }
   
   public static int mul(int a) {
      if(a>=100) {
         return (a/100)*(a%100/10)*(a%10);
      }else if(a>=10) {
         return (a/10)*(a%10);
      }else {
         return a;
      }
   }
}
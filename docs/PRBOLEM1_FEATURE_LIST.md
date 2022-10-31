## 슈도 코드

```
problem1(pobi[],crong[]){

        // exception
        if(!validCheck(pobi, crong)) return -1;
        
        // game logic
        pobiLeftMax=max(getDigitSum(pobi[0]),getDigitProduct(pobi[0]));
        pobiRightMax=max(getDigitSum(pobi[1]),getDigitProduct(pobi[1]));
        crongLeftMax=max(getDigitSum(crong[0]),getDigitProduct(crong[0]));
        crongRightMax=max(getDigitSum(crong[1]),getDigitProduct(crong[1]));
        pobiMax=max(pobiLeftMax,pobiRightMax);
        crongMax=max(crongLeftMax,crongRightMax);
        
        // pobi win
        if(pobiMax>crongMax){
            return 1;
        }
        // crong win
        if(pobiMax<crongMax){
            return 2;
        }
        // draw
        if(pobiMax==crongMax){
            return 0;
        }
}
```

## 기능 요구 사항
- 주어진 pobi[]와 crong[]이 올바른 입력인지 판별하는 bool validCheck(int[], int[]) 함수
- 자연수 입력에 대해 자릿수별 합을 구하는 int getDigitSum(int) 함수
- 자연수 입력에 대해 자릿수별 곱을 구하는 int getDigitProduct(int) 함수
- 두 자연수에 대해 더 큰 값을 반환하는 int max(int, int) 함수

TODO
- 
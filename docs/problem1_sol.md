#### 페이지 계산
```
target_page = 197
hundreds = target_page % 100
til_tens = target_page-hundreds*100
tens = til_tens % 10
units = til_tens-tens*10
```
#### 점수 구하기
```
max(hundreds+tens+units,hundreds*tens*units)
```
#파일 오픈
fopen = open("inputs/2193.txt")


#임포트
#import numpy as np

#파일입출력
#for line in fopen :
#    a = line.strip()
#a = int(a)

#a = int(input())

a = int(input())
l = [0 for _ in range(100)]

l[0] = 0
l[1] = 1
l[2] = 1

if a >= 3 :
    for i in range(3,a+1) :
        l[i] = l[i-1] + l[i-2]
    print(l[a])

else :
    print(l[a])








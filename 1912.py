import sys
sys.stdin = open("inputs/1912.txt") 

###############||INPUT||####################

N = int(input())
l = list(map(int,input().split()))

###############||LOGIC||##################

for i in range(0, N + 1) :
    for j in range(i, N + 1) :
        sum += l[i][j]








###############||RESULT||####################

print(N)
print(l)




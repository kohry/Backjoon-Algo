import sys

sys.stdin = open("inputs/10950.txt") 

############################################

N = int(input())

l = [0 for _ in range(100)]

for i in range(0, N) :
    a, b = map(int, input().split())
    print(a + b)

#############################################
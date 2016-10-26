
import sys
sys.stdin = open("inputs/1922.txt") 


class V :

    def __init__(self, a, b) :
        self.a = a
        self.b = b

    def __str__(self) :
        return "%s %s" % (self.a , self.b)

N = int(input())
M = int(input()) 

for i in range(0,N) :
    a,b,c = map(int,input().split())
    list[a][b] = c
    list[b][a] = c


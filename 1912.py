import sys
sys.stdin = open("inputs/1912.txt") 

###############||INPUT||####################

N = int(input())
l = list(map(int,input().split()))
c = [0 for _ in range(100001)]
m = [0 for _ in range(100001)]

###############||LOGIC||##################

# def getAnswer(n) :

#     if (n == 0) :
#         return c[0]

#     return max(c[n],getAnswer(n-1))


c[0] = l[0]
    
for i in range(1,N) :
    c[i] = max(c[i-1] + l[i],l[i])

m[0] = c[0]

for i in range(1,N) :
    m[i] = max(c[i], m[i-1])

#result = getAnswer(N)
result = m[N-1]

###############||RESULT||####################

print(result)




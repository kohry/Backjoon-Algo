n = int(input())
c = [200000000] * 3000020
 
c[1] = 0
 
for i in range (1,n + 1) :
    a = i * 3
    if (c[a] > c[i] + 1) :
        c[a] = c[i] + 1
    b = i * 2
    if (c[b] > c[i] + 1 ) :
        c[b] = c[i] + 1
    d = i + 1
    if (c[d] > (c[i] + 1) ) :
        c[d] = c[i] + 1
 
result = c[n]
 
print(result)

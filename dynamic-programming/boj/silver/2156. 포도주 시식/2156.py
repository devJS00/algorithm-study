n = int(input())

wine = [0] * 10001

for i in range(1, n+1):
    wine[i] = int(input())

d = [0] * 10001

d[1] = wine[1]
d[2] = wine[1] + wine[2]
d[3] = max(wine[1] + wine[3],  wine[2] + wine[3], d[2])

for i in range(4, n+1):
    d[i] = max(d[i-3] + wine[i-1] + wine[i], d[i-2] + wine[i], d[i-1])

print(d[n])

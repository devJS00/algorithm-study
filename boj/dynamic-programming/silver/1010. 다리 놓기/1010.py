t = int(input())

d = [[0] * 30 for _ in range(30)]

for i in range(30):
    for j in range(30):
        if i == 1:
            d[i][j] = j
        elif i == j:
            d[i][j] = 1
        elif i < j:
            d[i][j] = d[i - 1][j - 1] + d[i][j - 1]

for _ in range(t):
    n, m = map(int, input().split())
    print(d[n][m])

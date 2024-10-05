n = int(input())

score = [0] * 301
for i in range(1, n + 1):
    score[i] = int(input())

# d[i]: i번째 계단까지 도착했을 때 얻을 수 있는 최대 점수
d = [0] * 301

d[1] = score[1] # 첫 번째 계단의 최대 점수는 첫 번째 계단의 점수
d[2] = score[1] + score[2]  # 두 번째 계단의 최대 점수는 첫 번째 계단의 점수 + 두 번째 계단의 점수


for i in range(3, n+1):
    d[i] = max(d[i-3] + score[i-1] + score[i], d[i-2] + score[i])  # 현재 계단을 밟을 때와 현재 계단을 밟지 않을 때 중 큰 값을 선택

print(d[n])

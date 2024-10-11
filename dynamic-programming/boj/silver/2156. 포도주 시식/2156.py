n = int(input())
wine = [0] * (n + 1)

for i in range(1, n + 1):
    wine[i] = int(input())

if n == 1:
    print(wine[1])
elif n == 2:
    print(wine[1] + wine[2])
else:
    dp = [0] * (n + 1)  # dp[i]: i번째 잔까지 마실 수 있는 최대 포도주의 양을 저장

    dp[1] = wine[1]
    dp[2] = wine[1] + wine[2]

    for i in range(3, n + 1):
        # i번째 잔을 마시는 경우의 선택지는 다음과 같다:
        # i번째 잔을 마시지 않는 경우: dp[i-1]
        # i번째 잔을 마시고, i-1번째 잔을 마시지 않는 경우: dp[i-2] + wine[i]
        # i번째 잔과 i-1번째 잔을 마시고, i-2번째 잔은 마시지 않는 경우: dp[i-3] + wine[i-1] + wine[i]
        dp[i] = max(dp[i - 1], dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])

    print(dp[n])

def min_squares_sum(n):
    # d[i]는 i를 나타내는데 필요한 최소 제곱수 합의 개수
    d = [float('inf')] * (n + 1) # 무한대로 초기화

    d[0] = 0 # 0은 0개의 제곱수 합으로 표현 가능

    # 1부터 n까지 각 숫자에 대해 최소 개수의 제곱수 합을 계산
    for i in range(1, n + 1):
        j = 1
        while j * j <= i:
            d[i] = min(d[i], d[i - j * j] + 1)
            j += 1

    return d[n]

n = int(input())

result = min_squares_sum(n)
print(result)

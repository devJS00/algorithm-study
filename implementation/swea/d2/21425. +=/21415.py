T = int(input())
result = []

for test_case in range(1, T + 1):
    a, b, c = map(int, input().split())
    count = 0

    smaller = min(a, b)
    bigger = max(a, b)

    while smaller <= c and bigger <= c:
        smaller += bigger  # 작은 값에 큰 값을 더한다
        smaller, bigger = min(smaller, bigger), max(smaller, bigger)  # 다시 정렬
        count += 1

    result.append(count)

for r in result:
    print(r)

# 테스트 케이스 수 입력
T = int(input())

results = []

for test_case in range(1, T + 1):
    N = int(input())  # 일 수
    prices = list(map(int, input().split()))  # 매매가 리스트

    max_price = 0
    profit = 0  # 누적 이익

    for price in reversed(prices):
        if price > max_price:
            max_price = price  # 최고가 갱신
        else:
            profit += max_price - price  # 이익 계산

    results.append('#' + str(test_case) + ' ' + str(profit))

for r in results:
    print(r)

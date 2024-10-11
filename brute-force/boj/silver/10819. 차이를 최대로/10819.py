from itertools import permutations

n = int(input())  # 배열의 크기 N
a = list(map(int, input().split()))  # 배열 A

orders = list(permutations(a))
max_sum = 0
for order in orders:
    sum = 0
    for i in range(n - 1):
        sum += abs(order[i] - order[i + 1])

    max_sum = max(max_sum, sum)

print(max_sum)

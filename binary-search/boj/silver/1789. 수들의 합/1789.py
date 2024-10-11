S = int(input())

low, high = 1, S

while low <= high:
    mid = (low + high) // 2
    total_sum = mid * (mid + 1) // 2

    if total_sum <= S:
        low = mid + 1  # 더 큰 값을 탐색하기 위해 low 값을 증가 (mid 위치를 위로)
    else:
        high = mid - 1  # 더 작은 값을 탐색하기 위해 high 값을 감소

print(high)

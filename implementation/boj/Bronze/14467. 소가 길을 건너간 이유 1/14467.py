n = int(input())

prev_loc = [-1 for _ in range(11)]  # 소들의 이전 위치를 기록하는 리스트
count = 0

for _ in range(n):
    cow, cur_loc = map(int, input().split())

    if prev_loc[cow] != cur_loc and prev_loc[cow] != -1:  # 소가 이전에 관찰된 적이 있고, 현재 위치가 이전 위치와 다를 경우
        count += 1

    prev_loc[cow] = cur_loc  # 해당 소의 이전 위치를 현재 위치로 갱신

print(count)

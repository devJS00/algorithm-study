n = int(input())

w = []

for _ in range(n):
    w.append(list(map(int, input().split())))

min_cost = float('inf')


# start: 출발 도시
# current: 현재 위치한 도시
# cost: 현재까지 이동한 경로의 비용
def backtracking(start, current, cost):
    global min_cost

    if len(visited) == n and w[current][start] != 0:  # 모든 도시를 방문했고, 현재 도시에서 출발 도시로 돌아갈 수 있는 경로가 있을 때
        min_cost = min(min_cost, cost + w[current][start])
        return

    for i in range(n):
        if w[current][i] != 0 and i not in visited and cost < min_cost:
            visited.append(i)
            backtracking(start, i, cost + w[current][i])
            visited.pop()


for i in range(n):
    visited = [i]
    backtracking(i, i, 0)

print(min_cost)

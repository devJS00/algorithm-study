n, m = map(int, input().split())
castle = [input().strip() for _ in range(n)]

# 경비원이 없는 행과 열의 수 중 큰 값을 선택. 한 번에 행과 열을 모두 채울 수 있기 때문
row_cnt = 0
col_cnt = 0

for i in range(n):
    if not 'X' in castle[i]:
        row_cnt += 1

for i in range(m):
    if not 'X' in [castle[j][i] for j in range(n)]:
        col_cnt += 1

print(max(row_cnt, col_cnt))  

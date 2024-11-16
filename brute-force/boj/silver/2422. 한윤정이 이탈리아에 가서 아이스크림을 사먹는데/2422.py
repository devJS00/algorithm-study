from itertools import combinations

n, m = map(int, input().split())

can_mix = [[1] * (n + 1) for _ in range(n + 1)]  # 2차원 배열에 섞어먹으면 안 되는 조합 저장

for _ in range(m):
    i1, i2 = map(int, input().split())
    can_mix[i1][i2] = 0
    can_mix[i2][i1] = 0

combi = list(combinations(range(1, n + 1), 3))  # 1부터 n까지의 숫자 중에서 3개를 뽑는 모든 조합을 리스트로 저장
count = 0

for c in combi:
    if can_mix[c[0]][c[1]] == 1 and can_mix[c[0]][c[2]] == 1 and can_mix[c[1]][c[2]] == 1:  # c[0], c[1], c[2]는 각각 첫 번째, 두 번째, 세 번째 아이스크림을 의미
        count += 1

print(count)

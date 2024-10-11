n = int(input())  # 학생 수
classes = [list(map(int, input().split())) for _ in range(n)]
count = [0] * n
for i in range(n):
    for j in range(n):
        for grade in range(5):
            if classes[i][grade] == classes[j][grade] and i != j:
                count[i] += 1
                break  # 한 번 같은 반이었던 것이 확인되면 더 이상 비교하지 않음

print(count.index(max(count)) + 1)

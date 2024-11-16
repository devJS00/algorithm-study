n = int(input())  # 수열의 크기
a = list(map(int, input().split()))  # 수열 A

stack = []
result = [-1] * n

for i in range(n):
    while stack and a[stack[-1]] < a[i]:
        index = stack.pop()
        result[index] = a[i]
    stack.append(i)

print(' '.join(map(str, result)))

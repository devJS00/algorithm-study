n, s = map(int, input().split())
array = list(map(int, input().split()))

count = 0


def backtrack(idx, sum):
    global count

    if idx >= n:
        return

    if sum + array[idx] == s:
        count += 1

    backtrack(idx + 1, sum + array[idx])
    backtrack(idx + 1, sum)


backtrack(0, 0)

print(count)

# 다른 풀이
# n, s = map(int, input().split())
# array = list(map(int, input().split()))
# 
# count = 0
# selected = []
# 
# 
# def backtrack(idx):
#     global count
# 
#     if sum(selected) == s and len(selected) > 0:
#         count += 1
# 
#     for i in range(idx, n):
#         selected.append(array[i])
#         backtrack(i + 1)
#         selected.pop()
# 
# 
# backtrack(0)
# 
# print(count)

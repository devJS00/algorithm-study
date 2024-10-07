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

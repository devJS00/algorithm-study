n, m = map(int, input().split())

selected = []


def backtracking(j):
    if len(selected) == m:
        print(' '.join(map(str, selected)))
        return
    for i in range(j, n + 1):
        selected.append(i)
        backtracking(i)
        selected.pop()  # 재귀 호출이 끝나면 마지막으로 추가한 숫자를 제거하여 다음 반복에서 새로운 조합을 시도할 수 있게 함


backtracking(1)

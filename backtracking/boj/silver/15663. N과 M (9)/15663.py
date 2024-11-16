n, m = map(int, input().split())
array = list(map(int, input().split()))

selected = []

array.sort()  # 숫자들의 배열을 오름차순으로 정렬 (출력 순서를 정하기 위함)

visited = [False] * n


def backtracking():
    if len(selected) == m:
        print(' '.join(map(str, selected)))
        return

    prev = -1  # 중복된 숫자를 방지하기 위한 변수
    
    for i in range(n):
        if array[i] != prev and not visited[i]:
            visited[i] = True
            selected.append(array[i])
            backtracking()
            prev = selected.pop()  # prev를 마지막 선택한 숫자로 업데이트
            visited[i] = False


backtracking()

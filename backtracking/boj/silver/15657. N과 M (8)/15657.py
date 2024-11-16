n, m = map(int, input().split())
array = list(map(int, input().split()))

selected = []

array.sort()  # 숫자들의 배열을 오름차순으로 정렬 (출력 순서를 정하기 위함)


def backtracking(j):
    if len(selected) == m:
        print(' '.join(map(str, selected)))
        return

    for i in range(j, len(array)):
        selected.append(array[i])
        backtracking(i)
        selected.pop()  # 재귀 호출이 끝나면 마지막으로 추가한 숫자를 제거하여 다음 반복에서 새로운 조합을 시도할 수 있게 함


backtracking(0)  # array의 0번 인덱스부터 탐색 시작

n, m = map(int, input().split())

selected = []


def backtracking():
    if len(selected) == m:
        print(' '.join(map(str, selected)))
        selected
        return
    for i in range(1, n + 1):
        if i not in selected:  # 숫자 i가 이미 array에 포함되어 있지 않은 경우에만 다음 단계로 진행
            selected.append(i)
            backtracking()
            selected.pop()  # 재귀 호출이 끝나면 마지막으로 추가한 숫자를 제거하여 다음 반복에서 새로운 조합을 시도할 수 있게 함


backtracking()

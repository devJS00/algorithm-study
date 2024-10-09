def solution(name):
    answer = 0
    total_moves = 0
    # 알파벳 변경 횟수 계산
    for char in name:
        # 위로 가는 경우와 아래로 가는 경우 중 더 적은 것을 선택
        total_moves += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)
    
    # 커서 이동 횟수 계산
    min_move = len(name) - 1  # 기본은 오른쪽으로 끝까지 가는 경우
    
    for i in range(len(name)):
        # 현재 위치에서 연속된 A 구간의 끝을 찾음
        next_idx = i + 1
        while next_idx < len(name) and name[next_idx] == 'A':
            next_idx += 1
            
        right = len(name) - next_idx  # A 구간 이후 계속 오른쪽으로 이동하는 경우, 끝까지 가는 데 필요한 이동 거리
        back_distance = min(i, right)  # 먼저 오른쪽으로 가다가 돌아오는 것과 먼저 왼쪽으로 갔다가 오는 것 중 선택
        
        min_move = min(min_move, i + right + back_distance)
    answer = total_moves + min_move
    
    return answer

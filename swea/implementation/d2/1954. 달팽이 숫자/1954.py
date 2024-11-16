# 테스트 케이스 수 입력
T = int(input())

# 방향 정의 (오른쪽, 아래, 왼쪽, 위)
dx = [0, 1, 0, -1]  # 행 이동
dy = [1, 0, -1, 0]  # 열 이동

results = []

# 테스트 케이스 처리
for test_case in range(1, T + 1):
    N = int(input())

    # N x N 달팽이 배열 초기화
    snail = [[0] * N for _ in range(N)]

    x, y = 0, 0  # 시작 위치
    direction = 0  # 현재 방향 (0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위)

    for num in range(1, N * N + 1):
        snail[x][y] = num

        # 다음 위치 계산
        nx, ny = x + dx[direction], y + dy[direction]

        # 경계 밖이거나 이미 숫자가 있는 경우 방향 전환
        if nx < 0 or nx >= N or ny < 0 or ny >= N or snail[nx][ny] != 0:
            direction = (direction + 1) % 4  # 방향 전환
            nx, ny = x + dx[direction], y + dy[direction]  # 전환된 방향으로 이동

        # 위치 업데이트
        x, y = nx, ny

    results.append(f"#{test_case}")
    for row in snail:
        results.append(" ".join(map(str, row)))

print("\n".join(results))

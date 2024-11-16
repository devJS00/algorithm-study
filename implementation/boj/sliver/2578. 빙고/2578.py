bingo = [list(map(int, input().split())) for _ in range(5)]
called = []
for _ in range(5):
    called.extend(list(map(int, input().split())))


def check():
    bingo_count = 0

    # 가로줄 체크
    for i in range(5):
        if all(bingo[i][j] == 0 for j in range(5)):
            bingo_count += 1

    # 세로줄 체크
    for j in range(5):
        if all(bingo[i][j] == 0 for i in range(5)):
            bingo_count += 1

    # 좌상단-우하단 대각선 체크
    if all(bingo[i][i] == 0 for i in range(5)):
        bingo_count += 1

    # 우상단-좌하단 대각선 체크
    if all(bingo[i][4 - i] == 0 for i in range(5)):
        bingo_count += 1

    return bingo_count


for i in range(25):
    for x in range(5):
        for y in range(5):
            if called[i] == bingo[x][y]:
                bingo[x][y] = 0
    if check() >= 3:
        print(i + 1)
        break

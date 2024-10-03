a = int(input())  # 게임을 진행하는 사람 수
t = int(input())  # 구하고자 하는 번째
s = int(input())  # 구하고자 하는 구호가 “뻔”이면 0, “데기”면 1

arr = []
bbun_cnt = 0
degi_cnt = 0
repeat = 2  # 이번 회차에 ‘뻔’ 또는 ‘데기’를 몇 번 반복하는지

while True:
    for _ in range(2):
        bbun_cnt += 1
        arr.append((bbun_cnt, 0))
        degi_cnt += 1
        arr.append((degi_cnt, 1))

    for _ in range(repeat):
        bbun_cnt += 1
        arr.append((bbun_cnt, 0))

    for _ in range(repeat):
        degi_cnt += 1
        arr.append((degi_cnt, 1))

    repeat += 1

    if bbun_cnt > t:
        break

print(arr.index((t, s)) % a)

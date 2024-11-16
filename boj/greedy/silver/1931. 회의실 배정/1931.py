n = int(input())

meetings = []

for i in range(0,n):
    start, end = map(int, input().split(" "))
    meetings.append([start, end])

meetings.sort(key=lambda x: (x[1], x[0]))

cnt = 0
cur_end = 0

for s, e in meetings:
    if s >= cur_end:
        cur_end = e
        cnt += 1

print(cnt)

arr = [i for i in range(1, 31)]

for _ in range(28):
    n = int(input())

    if n in arr:
        arr.remove(n)

for a in arr:
    print(a)

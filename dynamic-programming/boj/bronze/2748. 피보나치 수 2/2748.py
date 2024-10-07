n = int(input())
d = [0, 1]


def fibo(x):
    for i in range(2, n + 1):
        d.append(d[i - 2] + d[i - 1])
    print(d.pop())


fibo(n)

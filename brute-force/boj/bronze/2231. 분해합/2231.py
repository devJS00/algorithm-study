n = int(input())
count = 0

for i in range(1, n + 1):
    sum = i  # 자기 자신을 더함
    temp = i

    while temp > 0:
        sum += temp % 10  
        temp //= 10 

    if sum == n:
        print(i)
        break

else:
    print('0')

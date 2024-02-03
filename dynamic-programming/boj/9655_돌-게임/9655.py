n = int(input())

d = [0] * 1001
d[1] = 'SK'
d[2] = 'CY'
d[3] = 'SK'

for i in range(4, n+1):
    if d[i-1] == 'SK' or d[i-3] == 'SK':
        d[i] = 'CY'
    else:
        d[i] = 'SK'

print(d[n])

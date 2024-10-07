jun_money = sung_money = int(input())
prices = list(map(int, input().split()))
jun_stock, sung_stock = 0, 0

for i in range(14):
    if jun_money >= prices[i]:
        jun_stock += jun_money // prices[i]
        jun_money = jun_money % prices[i]

jun_total_asset = jun_money + jun_stock * prices[-1]

increase_cnt = decrease_cnt = 0
for i in range(3, 14):
    # 3일 연속 상승
    if prices[i - 3] < prices[i - 2] < prices[i - 1] < prices[i]:
        if sung_stock > 0:
            sung_money += sung_stock * prices[i]  # 전량 매도
            sung_stock = 0  # 주식 수 0으로 갱신
    # 3일 연속 하락
    elif prices[i - 3] > prices[i - 2] > prices[i - 1] > prices[i]:
        if sung_money >= prices[i - 1]:
            sung_stock += sung_money // prices[i]  # 전량 매수
            sung_money %= prices[i]  # 남은 현금 갱신

sung_total_asset = sung_money + sung_stock * prices[-1]

if jun_total_asset > sung_total_asset:
    print("BNP")
elif jun_total_asset < sung_total_asset:
    print("TIMING")
else:
    print("SAMESAME")

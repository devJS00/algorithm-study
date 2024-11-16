import sys

N = int(input())
numbers = list(map(int, input().split()))
plus, minus, multiply, divide = map(int, input().split())

max_value = -sys.maxsize
min_value = sys.maxsize


def calculate(idx, current_result):
    global max_value, min_value, plus, minus, multiply, divide

    if idx == N:
        max_value = max(max_value, current_result)
        min_value = min(min_value, current_result)

    if plus:
        plus -= 1
        calculate(idx + 1, current_result + numbers[idx])
        plus += 1

    if minus:
        minus -= 1
        calculate(idx + 1, current_result - numbers[idx])
        minus += 1

    if multiply:
        multiply -= 1
        calculate(idx + 1, current_result * numbers[idx])
        multiply += 1

    if divide:
        divide -= 1
        if current_result < 0:
            calculate(idx + 1, -(-current_result // numbers[idx]))
        else:
            calculate(idx + 1, current_result // numbers[idx])
        divide += 1


calculate(1, numbers[0])  # 계산 시작 (첫 번째 숫자는 그대로 시작)

print(max_value)
print(min_value)

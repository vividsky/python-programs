n = int(input())
print(n, end = ' ')
while n != 1:
    if n & 1:
        n = n*3+1
    else:
        n = n//2
    print(n, end=' ')
print()

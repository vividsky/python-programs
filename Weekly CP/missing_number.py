n = int(input())
arr = sorted(list(map(int, input().split())))
if n not in arr:
    print(n)
elif 1 not in arr:
    print(1)
else:
    for i in range(len(arr)-1):
        if arr[i+1]-arr[i] > 1:
            print(i+2)
            break

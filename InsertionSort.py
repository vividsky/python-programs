def insertionSort(arr):
   for i in range(len(arr)-1):
      if arr[i]>arr[i+1]:
         key = arr[i+1]
         for j in range(i,-1,-1):
            if arr[j]>key:
               arr[j+1] = arr[j]
            else:
               arr[j+1] = key
               break
   
   return arr

arr = list(map(int, input('Elements: ').strip().split()))

print(insertionSort(arr))
def power(a,p):
   for i in range(0,p):
      temp_set = set()
      for j in range(0,a):
         if (i & (1<<j)) != 0 :
            temp_set.add(arr[j])
      power_set.append(temp_set)
   return power_set

if __name__ == '__main__':
   N = int(input('N: '))
   arr = []
   for i in range(1,N+1):
      arr.append(i)
   arr_size = N
   power_set_size = 2**N
   power_set = []
   print(power(arr_size, power_set_size))

   

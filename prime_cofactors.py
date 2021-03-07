n = 10
prime = [0 for i in range(n+1)]
p = 2
while p<=10:
   if not prime[p]:
      for j in range(p,n+1,p):
         prime[j]+=1
   p+=1
cache = {}
for i,j in zip(range(n+1),prime):
    cache[i] = j
print(cache)


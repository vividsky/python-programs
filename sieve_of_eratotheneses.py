prime = []
def seive(n):
    global prime
    cache = [True for i in range(n+1)]

    p = 2
    while p*p <= n:
        if cache[p]:
            for j in range(p*p, n+1, p):
                cache[j] = False
        p += 1
    for i in range(2, len(cache)):
        if cache[i]:
            prime.append(i)
    return prime
 

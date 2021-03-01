from math import sqrt
def prime(n):
    for j in range(2,int(sqrt(n))+1):
        if n%j == 0:
            return False
    return True
def num():
    for i in range(1000001,1000000000):
        if prime(i) == True:
            return i
prime(25)
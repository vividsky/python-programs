cache = {}


def fib(n):
    if n == 1:
        return 1
    elif n == 2:
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)


def fibonacci(n):
    if n in cache:
        return cache[n]
    else:
        if n == 1:
            return 1
        elif n == 2:
            return 1
        else:
            value = fibonacci(n-1) + fibonacci(n-2)
            cache[n] = value
        return value


for n in range(1, 50):
    print(f'{n} : {fibonacci(n)}')

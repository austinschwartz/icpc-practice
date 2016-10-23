def primes_sieve(limit):
    limitn = limit+1
    not_prime = set()
    primes = []
    for i in range(2, limitn):
        if i in not_prime:
            continue
        for f in range(i*2, limitn, i):
            not_prime.add(f)
        primes.append(i)
    return primes

a = primes_sieve(10001)

def f(m):
    if m not in a:
        return False
    s = set()
    while m != 1:
        if m == 1:
            return True
        if m in s:
            return False
        s.add(m)
        digits = list(map(int, list(str(m))))
        summ = 0
        for d in digits:
            summ += (d ** 2)
        if summ == m:
            return False
        m = summ
    return m == 1
    

P = int(input())
for i in range(P):
    (K, m) = map(int, input().split(' '))
    if f(m):
        print("{} {} {}".format(K, m, "YES"))
    else:
        print("{} {} {}".format(K, m, "NO"))

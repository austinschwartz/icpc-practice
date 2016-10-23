P = int(input())

def f(p, q):
    return (q, ((2*int(p/q) + 1)*q) - p)

for i in range(P):
    line = input().split(' ')
    K = int(line[0])
    (p, q) = map(int, line[1].split('/'))
    (pp, qq) = f(p, q)
    print("{} {}/{}".format(K, int(pp), int(qq)))

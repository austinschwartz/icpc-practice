def f(s, l):
    count = 0
    b1 = 1 << 17
    while b1 > 0:
        l1 = l ^ b1
        if l1 < i:
            continue
        if l1 in s:
            count += 1
        b2 = b1 >> 1
        while b2 > 0:
            l2 = l1 ^ b2
            if l2 > l and l2 in s:
                count += 1
            b2 >>= 1
        b1 >>= 1
    return count

i = 0
l = []
s = set()
while True:
    try:
        i = int(input())
        if i != -1:
            l.append(i)
            s.add(i)
    except EOFError:
        break
    if i == -1:
        for ii in l:
            print("{}:{}".format(ii, f(s, ii)))
        l = []
        s = set()
        continue

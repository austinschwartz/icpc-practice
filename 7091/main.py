P = int(input())

def f(nums, n):
    count = 0
    for j in range(0, n - 1):
        for i in range(j + 1, n):
            if nums[i] < nums[j]:
                count += 1
    return count

for i in range(P):
    line = input().split(' ')
    K = int(line[0])
    nums = list(map(int, line[1:]))
    print("{} {}".format(K, f(nums, len(nums))))

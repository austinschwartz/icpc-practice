#!/bin/python3
while True:
    n = 0
    try:
        n = int(input())
    except:
        break
    increasing = False
    decreasing = False
    broke = False
    prev = ""
    for i in range(0, n):
        s = input()
        if i > 0:
            if s > prev:
                if decreasing:
                    broke = True
                increasing = True
            if s < prev:
                if increasing:
                    broke = True
                decreasing = True
        prev = s

    if increasing and not decreasing and not broke:
        print("INCREASING")
    elif decreasing and not increasing and not broke:
        print("DECREASING")
    else:
        print("NEITHER")


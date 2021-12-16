# x = int(input("plead input"))
# print(x)

# words = ["11", "2", "3"]
# for w in words:
#     print(w, len(w))

# for i in range(0, 5):
#     print(i)

# for i in range(0, 10, 3):
#     print(i)

# for i in range(5):
#     print(i)

# a=["1","23"]
# for i in range(len(a)):
#     print(i,a[i])

# print(sum(range(4)))
# arr=list(range(4))

def fib(n):
    a, b = 0, 1

    while a < n:
        print(a, end=' ')
        a, b = b, a+b
        print()


# fib(10)


def fib2(n):

    result = []
    a, b = 0, 1

    while a < n:
        result.append(a)
        a, b = b, a+b
    return result


ff = fib2(20)
print(ff)


def f(a, L=[]):
    L.append(a)
    return L


print(f(1))
print(f(2))
print(f(3))


def cheeseshop(kind, *arguments, **keywords):
    print("-- Do you have any", kind, "?")
    print("-- I'm sorry, we're all out of", kind)
    for arg in arguments:
        print(arg)
    print("-" * 40)
    for kw in keywords:
        print(kw, ":", keywords[kw])


cheeseshop("Limburger", "It's very runny, sir.",
           "It's really very, VERY runny, sir.",
           shopkeeper="Michael Palin",
           client="John Cleese",
           sketch="Cheese Shop Sketch")

list(range(3, 6))

args = [3, 6]
list(range(*args))

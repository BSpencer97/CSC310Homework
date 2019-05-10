def heap(a, n, i):
    max = i  #max
    l = 2*i+1  #left
    r = 2*i+2  #right

    #if left child exists and is greater than max/root
    if l < n and a[i] < a[l]:
        max = l

    #if right child exists and is greater than max/root
    if r < n and a[max] < a[r]:
        max = r

    #if max != i, swap and then recurse using the root
    if max != i:
        t = a[i]
        a[i] = a[max]
        a[max] = t
        heap(a, n, max)


def heapSort(a):
    n = len(a)
    #construct max heap
    for i in range(n, -1, -1):
        heap(a, n, i)
    for i in range(n-1, 0, -1):
        t = a[i]
        a[i] = a[0]
        a[0] = t
        heap(a, i, 0)

if __name__ == '__main__':

    a = [9, 7, 5, 2, 6, 4]
    print("Unsorted array is")
    print(a)
    heapSort(a)
    print("Sorted array is")
    print(a)
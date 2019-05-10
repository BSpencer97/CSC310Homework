class BinHeap:

    def __init__(self):
        self.heap = [0]
        self.currentSize = 0

    def size(self):
        return self.currentSize

    def is_empty(self):
        return self.currentSize == 0

    def downheap(self, i):
        while (i * 2) <= self.currentSize:
            mc = self.minChild(i)
            if self.heap[i] > self.heap[mc]:
                tmp = self.heap[i]
                self.heap[i] = self.heap[mc]
                self.heap[mc] = tmp
            i = mc

    def upheap(self, i):
        while i//2 > 0:
          if self.heap[i] < self.heap[i//2]:
             t = self.heap[i//2]
             self.heap[i//2] = self.heap[i]
             self.heap[i] = t
          i = i//2

    def insert(self, k):
        self.heap.append(k)
        self.currentSize = self.currentSize+1
        self.upheap(self.currentSize)

    def minChild(self, i):
        if i * 2 + 1 > self.currentSize:
            return i * 2
        else:
            if self.heap[i*2] < self.heap[i*2+1]:
                return i*2
            else:
                return i*2+1

    def del_min(self):
        min = self.heap[1]
        self.heap[1] = self.heap[self.currentSize]
        self.currentSize = self.currentSize - 1
        self.heap.pop()
        self.downheap(1)
        return min

    def find_min(self):
        min = self.heap[1]
        return min

    def build_heap(self, a):
        i = len(a)//2
        self.currentSize = len(a)
        self.heap = [0] + a[:]
        while (i > 0):
            self.downheap(i)
            i = i-1

if __name__ == '__main__':

    Bh = BinHeap()
    Bh.insert(5)
    Bh.insert(7)
    Bh.insert(3)
    Bh.insert(11)
    print(Bh.is_empty())
    print("min",Bh.find_min())
    print("del",Bh.del_min())
    print("min",Bh.find_min())
    print("size",Bh.size())
    Bh.insert(21)
    Bh.insert(0)
    print("min",Bh.find_min())
    print("del",Bh.del_min())
    print("min",Bh.find_min())
    print("size",Bh.size())
    a = [-1, -5, -3]
    Bh.build_heap(a)
    print("min",Bh.find_min())
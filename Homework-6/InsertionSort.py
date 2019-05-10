class PriorityQueue(object):
    def __init__(self):
        self.queue = []

    def __str__(self):
        return ' '.join([str(i) for i in self.queue])

    def __len__(self):
        return len(self.queue)

    def add(self, data):
        self.queue.append(data)

    def delete(self) -> object:
        if self.is_empty():
            print("Empty Queue!")
            return
        max = 0
        for i in range(len(self)):
            if self.queue[i] > self.queue[max]:
                max = i
        item = self.queue[max]
        del self.queue[max]
        return item

    def is_empty(self):
        return len(self) == 0

    def sort(self):
        a = [0]*len(self)
        i = 0
        while not self.is_empty():
            x = self.delete()
            a[i] = x
            if i == len(a)-1:
                break;
            i = i + 1
        insertionSort(a)
        for j in range(0, len(a)):
            self.add(a[j])

    def insertSeq(self, a):
        for i in range(0, len(a)):
            prQ.add(a[i])
        prQ.sort()
        i = len(a)
        while not prQ.is_empty() and i > 0:
            a[i - 1] = prQ.delete()
            i = i - 1
        return a


def insertionSort(a):
   for i in range(1, len(a)):
     curr = a[i]
     pos = i
     while pos > 0 and a[pos-1] > curr:
         a[pos] = a[pos-1]
         pos = pos-1
     a[pos]= curr

if __name__ == '__main__':

    prQ = PriorityQueue()
    a = [7, 4, 8, 2, 5, 3, 9]
    a = prQ.insertSeq(a)
    print("S:", a)
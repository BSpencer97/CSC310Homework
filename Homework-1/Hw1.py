# Name: Brian Spencer
# Date: 1/27/19
# Course: CSC 310
# Project: Homework 1

# Function to determine if there is at least one distinct pair of
# elements in an array whose product is odd.
# An array is the only required input.
def isOdds(a):
    n = len(a)
    for i in range(0, n): #iterate over array twice
        for j in range(0, n):
            if i != j: #ensures only distinct pairs are checked
               if (a[i]*a[j])%2 != 0: #an odd product will result in 1 at this check
                   return(True)
    return(False) #return false after finding no pairs

oddsTest1 = [1,2,4,8,16,32,64,77]
print(isOdds(oddsTest1))

oddsTest2 = [3,0,0,1]
print(isOdds(oddsTest2))

oddsTest3 = [2,6,14,0]
print(isOdds(oddsTest3))

oddsTest4 = [2,2,2,2,1]
print(isOdds(oddsTest4))

class Ham :

    x = 0
    y = 0
    xstr = ""
    ystr = ""

    #Constructor used for the two inputs and their binary equivalent.
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.xstr = self.dToB(self.x)
        self.ystr = self.dToB(self.y)

    # Function to convert a decimal number to binary.
    # Takes a number as an input.
    def dToB (self, n):
        s = ""
        while n > 0: #While n > 0, add an appropriate character onto a string to convert to binary
            if n%2 == 0:
                s = "0" + s
            else:
                s = "1" + s
            n = n//2
        return s #return string

    # Function to find the Hamming Distance between two numbers.
    # Requires two strings(part of object) to compare and output difference.
    def hamDis (self):
        s = self.xstr
        t = self.ystr

        sl = len(s)
        tl = len(t)

        n = abs(sl - tl) #determine how much padding the shorter string needs
        for i in range (0, n):
            if sl < tl: #pad the shorter string with 0's
                s = "0" + s
            else:
                t = "0" + t

        cnt = 0
        for i in range(0, max(sl, tl)): #counting each difference in characters between strings
            if s[i] != t[i]:
                cnt += 1
        #printing information about each number and then their Hamming Distance
        print("x:")
        print("dec", self.x)
        print("bin", s)

        print("y:")
        print("dec", self.y)
        print("bin", t)

        print("Hamming Distance:", cnt)

if __name__ == "__main__":
    print("Enter x: ", end= ' ')
    x = int(input())
    print("Enter y: ", end=' ')
    y = int(input())
    h = Ham (x, y)
    h.hamDis()

    words = []
    while True: #allows for many inputs
        try:
            word = input("Enter an input: ")
            words.append(word) #add inputs to a list
        except EOFError as error:
            # Output expected EOFErrors.
            for i in range(0, len(words)):
                print(words[len(words) - (i+1)]) #once Ctrl+D is inputted, prints out the inputs backwards
            break

# Function to output all possible permutations
# of an array of numbers
# Takes an array, zero, and the length of that array as parameters.
def permute(a, l, r):
    if l == r-1: #base case, will print once lower and upper bound are the same index
        print(a)
    else:
        for i in range(l, r):
            temp = a[l] #these swaps make the starting index for a list with the elements past 'l' to swap
            a[l] = a[i]
            a[i] = temp
            permute(a, l+1, r)
            temp = a[l] #undo the swap before
            a[l] = a[i]
            a[i] = temp

permTest1 = ['z','y','x']
permute(permTest1, 0, len(permTest1))

permTest2 = [0,4,8,6]
permute(permTest1, 0, len(permTest2))
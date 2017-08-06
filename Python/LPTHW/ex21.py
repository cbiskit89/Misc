def add(x, y):
    print "Add %d to %d" % (x, y)
    return x + y

def subtract(x, y):
    print "Subtract %d from %d" % (y, x)
    return x - y

def multiply(x, y):
    print "Multiply %d and %d" % (x, y)
    return x * y

def divide(x, y):
    print "Divide %d by %d" % (x, y)
    return x / y

print "Let's do some math."

age = add(20, 5)
height = subtract(72, 3)
weight = multiply(75, 2)
iq = divide(260, 2)

print "Age: %d\nHeight: %d\nWeight: %d\nIQ: %d\n" % (
    age, height, weight, iq)

print "Here is a puzzle."

what = add(age, subtract(height, multiply(weight, divide(iq, 2))))

print "It becomes: %d" % what

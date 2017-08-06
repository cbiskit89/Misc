name = "Cory"
age = 25
height = 69 # inches
weight = 155 # pounds
eyes = "Blue"
teeth = "White" # I hope.
hair = "Brown"

print "Let's talk about %s." % name
print "He is %s years old." % age
print "He is %s inches tall." % height
print "He weighs %s pounds." % weight
print "Hopefully that's not too heavy."
print "He has %s eyes and %s hair." % (eyes, hair)
print "His teeth are usually %s unless he has a lot of coffee." % teeth

print "If I add %d, %d, and %d I get %d." % (
    age, height, weight, age + height + weight)

height_in_centimeters = height * 2.54
weight_in_kg = weight * 0.453592

print height_in_centimeters
print weight_in_kg

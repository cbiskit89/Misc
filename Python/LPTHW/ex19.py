def cheese_and_crackers(cheese_count, boxes_of_crackers):
    print "You have %d cheeses!" % cheese_count
    print "You have %d boxes of crackers!" % boxes_of_crackers
    print "That's enough for a party!"
    print "Get a blanket!\n"

print "Pass numbers directly to function."
cheese_and_crackers(10, 20)

print "Or we can use variables."
amount_of_cheeses = 10
amount_of_crackers = 50

cheese_and_crackers(amount_of_cheeses, amount_of_crackers)

print "We can even do math when passing arguments."
cheese_and_crackers(10 + 15, 30 + 15)

print "And we can do variables and math."
cheese_and_crackers(amount_of_cheeses + 10, amount_of_crackers + 10)

from sys import argv

script, filename = argv

print "We are going to replace %r." % filename
print "If you do not want to do that press Ctrl+C (^C)"
print "If you do want that, press Return."

raw_input("?")

print "Opening file..."
target = open(filename, 'w')

# AKA delete the contents of the file.
print "Truncating the file. Bye!"
target.truncate()

print "Now I'm going to ask you for three lines."

line1 = raw_input("Line 1: ")
line2 = raw_input("Line 2: ")
line3 = raw_input("Line 3: ")

print "I'm going to write these to the file."

new_file_input = line1 + "\n" + line2 + "\n" + line3 + "\n"
target.write(new_file_input)

print "And finally we close it."
target.close()

print "Now reopen.."
target = open(filename, 'r')

print "Here it is:"
print target.read()

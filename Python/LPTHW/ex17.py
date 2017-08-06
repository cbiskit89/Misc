from sys import argv
from os.path import exists

script, from_file, to_file = argv

print "We will copy %r to %r." % (from_file, to_file)

# This could be one line.
in_file = open(from_file)
indata = in_file.read()
# End This

print "The input data is %d bytes long." % len(indata)

print "Does the output file exist? %r" % exists(to_file)
print "Press Enter to begin or Ctrl+C to exit."
raw_input()

out_file = open(to_file, 'w')
out_file.write(indata)

print "Alright, done."

out_file.close()
in_file.close()

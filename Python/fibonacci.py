#!/usr/bin/python2.7
import signal
import sys
import time

def fibo((a, b)):
  yield (b, a+b)

def handler(signal, frame):
  sys.exit(0)

signal.signal(signal.SIGINT, handler)
print 'Press Ctrl+C to exit'
seq = (0, 1)
while True:
  print seq[0],
  seq = next(fibo(seq))
  sys.stdout.flush()
  time.sleep(1)

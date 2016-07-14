#!/usr/bin/python2.7
import xml.etree.ElementTree as etree

def walk_tree(root_node):
    child_elements = 0
    for child in root_node:
        if child.getchildren():
            child_elements += walk_tree(child)
        child_elements += len(child.attrib)
    return child_elements

xml = ''
n = int(raw_input())
for i in range(n):
    xml += raw_input()
tree = etree.ElementTree(etree.fromstring(xml))
root = tree.getroot()
num_elements = len(root.attrib) + walk_tree(root)

print num_elements

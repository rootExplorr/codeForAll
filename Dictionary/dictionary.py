from node import Node

class Dictionary:
  root = Node("")
  gNode = ""
  wordList = []

  def createNewTree(self,str,i):
     root = Node("")
     list = root.list = [None] * 26
     root.word = str[:i+1]

     if len(str)-1 == i:
      root.isComplete = True
      return root

     for j in range(i+2,len(str)+1):
         node = Node("")
         node.list = [None] * 26
        
         node.word = str[:j]
         list[ord(str[j-1])-97] = node
         list = node.list
     node.isComplete = True
     return root

  def findWords(self,node,retreiveWord=False):
    list = node.list
    for cNode in list:
     if cNode:
       if cNode.isComplete:
        if retreiveWord:
          self.wordList.append(cNode.word)
        else:
          print cNode.word
       if(cNode.list != None):
        self.findWords(cNode,retreiveWord)

  def addWord(self,nStr):
    length = len(nStr);
    if self.root.list == None:
      self.root.list = [None] * 26

    str = ""
    index = -1
    for i in range(1,length+1):
     if i == 1:
      list = self.root.list;

     str = nStr[:i]
     index = ord(nStr[i-1])-97   
     if list[index] and str == list[index].word:
      list = list[index].list    
     else:
      newNode = self.createNewTree(nStr,i-1)    
      list[index] = newNode
      break; 
  
  def searchDictionary(self,word):
    list = self.root.list
    characters = ""
    index = -1

    for i in range(1,len(word)+1):
      index = ord(word[i-1])-97
      node = list[index]
      characters = word[:i]
      if node is not None and characters == node.word:
        list = node.list
        continue
      else:
        return None    
    self.gNode = node
    self.wordList = []
    self.findWords(node,True)
    if node.isComplete:
      self.wordList.insert(0,node.word)
    return self.wordList


  def printDictionary(self,node):
    self.findWords(self.root)
  # list = node.list
  # for cNode in list:
  #  if(cNode):
  #    if(cNode.isComplete):
  #     print cNode.word
  #    if(cNode.list != None):
  #     self.printDictionary(cNode
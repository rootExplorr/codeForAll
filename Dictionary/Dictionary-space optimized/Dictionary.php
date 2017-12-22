<?php
include 'node.php';

class Dictionary{
  public $root;

  function __construct(){
    $this->root = new Node("");
  }

  function createNewTree($str,$i){
      $root = new Node("");
      $root->list = array_fill (0,26,"");
      $list = &$root->list;

      $root->word = substr($str,0,$i+1);

      if(strlen($str)-1 == $i){
        $root->isComplete = True;
        return $root;
      }

      for($j=$i+2;$j<strlen($str)+1;$j++){
        unset($node);
        $node = new Node("");
        $node->list = array_fill (0,26,"");
        $node->word = substr($str,0,$j);
        $list[ord($str[$j-1])-97] = &$node;
        $list = &$node->list;
      }
     $node->isComplete = True;
     return $root;
  }

  function findWords(&$node,$prefix,& $wordList){
    $rootWord = $prefix;
    $childList =& $node;
    while($childList!=NULL){
       if ($childList->isComplete){
          array_push($wordList, $rootWord.$childList->word);
       }
       if($childList->child != NULL){
        $this->findWords($childList->child,$rootWord.$childList->word,$wordList);
       }
       $childList =& $childList->next;
    }
  }
 
  function addWord($nStr){
    $bckpStr = $nStr;
    if($this->root->child == NULL){
      $this->addChild($this->root,$nStr);
    }
    else{
      $node =& $this->root->child;
      $root = $this->root;
      $flag = FALSE;
      $x=0;

      while($node!=NULL){
        if($node->word == substr($nStr,0,strlen($node->word))){
          $nStr = substr($nStr,strlen($node->word));
          $x=$x+strlen($node->word);
          $root =& $node;
          $node =& $node->child;
          continue;
        }
        else if($y=$this->isPartialMatch($node->word,$nStr)){
          $x=(strlen($bckpStr)-strlen($nStr)) + $y;
          $flag = TRUE;
          break;
        }
        $node=&$node->next;
      }

    if($flag){
      $this->createSubTree($node,$y);
      $root =& $node;
      $root->isComplete = FALSE;
    }
    $newWord = substr($bckpStr,$x);
    if(strlen($newWord)>0)
      $this->addChild($root,$newWord);
    }
  }
  
function searchDictionary($word){
    $bckpStr = $word;
    $childNode =& $this->root->child;
    $characters = "";
    $index = -1;
    $wordList = array();

    while($childNode!=NULL){
      if(strlen($childNode->word) < strlen($word)){
        if(strcmp($childNode->word,substr($word,0,strlen($childNode->word))) == 0){
          $word = substr($word,strlen($childNode->word));
          $childNode =& $childNode->child;
          continue;
        }
      }
      else if(strlen($childNode->word) >= strlen($word)){
        if(strcmp($word,substr($childNode->word,0,strlen($word))) == 0 ){
         // echo $word;
          //echo $bckpStr;
           $prefix = substr($bckpStr,0,strlen($bckpStr)-strlen($word));
          $prefix=$prefix.$childNode->word;
          echo $prefix;
          if($childNode->isComplete==1){
            array_push($wordList,$prefix);
          }
          else{
         
          $this->findWords($childNode->child,$prefix,$wordList);
          }
          return $wordList;
        }
      }
      $childNode =& $childNode->next;
    }
    
    /*
    for($i=1;$i<strlen($word)+1;$i++){
      unset($node);
      $index = ord($word[$i-1])-97;
      $node =& $list[$index];
      $characters = substr($word,0,$i);
      if($node != NULL and $characters == $node->word){
        $list =& $node->list;
        continue;
      }
      else return NULL;
    }
    $this->gNode =& $node;
    $this->wordList = [];
    $this->findWords($node,True);
    if($node->isComplete)
      array_splice($this->wordList,0,0, $node->word);
    return $this->wordList;*/
}

function printDictionary($node){
  $wordList = array();
  $this->findWords($node->child,"",$wordList);
  return json_encode($wordList);
}

function createSubTree(&$node,$x){
  $isComplete = $node->isComplete;
  $str = $node->word;
  $node->word = substr($str,0,$x);
  $node->isComplete = FALSE;
  $str = substr($str,$x,strlen($str));

  $newNode = new Node("");
  $newNode->word = $str;
  $newNode->child =& $node->child;
  if($isComplete)
    $newNode->isComplete = $isComplete;
  $node->child =& $newNode;
}

function addChild(&$node,$nStr){
  $newNode = new Node("");
  $newNode->word = $nStr;
  $newNode->isComplete = TRUE;
  $newNode->next =& $node->child; 
  $node->child =& $newNode;
}

function isPartialMatch($nodeStr,$inptStr){
  for($i=0;$i<strlen($nodeStr);$i++){
      if(strcmp($nodeStr[$i],$inptStr[$i])!=0){
        return $i;
      }
  }
  return 1;
}

}
?>
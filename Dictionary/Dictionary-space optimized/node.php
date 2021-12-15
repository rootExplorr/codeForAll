<?php 
class Node {
  public $word = "";
  public $next = NULL;
  public $child = NULL;
  public $isComplete = False;

  function __construct($word){
  $this->word = $word;
  }
  
  function getWord(){
  return $this->word;
  }
 
  function setWord($word){
  $this->word = $word;
  }
  
  function getList(){
  return $this->list;
  }
 
  function setList($list){
  $this->list = $list;
  }
}
?>
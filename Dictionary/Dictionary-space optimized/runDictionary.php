<?php

include 'Dictionary.php';

$dictionary = new Dictionary();

$dictionary->addWord("salil");
$dictionary->addWord("sam");
$dictionary->addWord("mission");
$dictionary->addWord("major");
$dictionary->addWord("misra");
$dictionary->addWord("more");
$dictionary->addWord("majority");
$dictionary->addWord("salon");
$dictionary->addWord("retire");
$dictionary->addWord("retreat");
$dictionary->addWord("reserve");
$dictionary->addWord("excellent");
$dictionary->addWord("beautiful");
$dictionary->addWord("tranquil");
$dictionary->addWord("examine");
$dictionary->addWord("wonder");


print_r($dictionary->searchDictionary("ma"));
//print_r($dictionary->root->child->next->next->next);
//echo $dictionary->printDictionary($dictionary->root);
?>
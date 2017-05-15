Google interview questions: 

1. Word Squares
Given a set of words without duplicates, find all word squares you can build from them.
A sequence of words forms a valid word square if the kth row and column read the exact same string, 
where 0 ≤ k < max(numRows, numColumns).
For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both 
horizontally and vertically.

DFS: time out , we need to prune;
Redundancies:
1. previsous words form prefix of nextWord. For example: first word: wall, second word should be a***
2. previsous words form prefixes of following words For example:first word: wall, second word should be area, the following words
should be le** and la**

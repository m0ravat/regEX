# RegEX 
The purpose of regex is for string validation or to ensure it follows a certain pattern, can be used for email validation, validating upper/lowercase where built in functions may fail and so on. A crucial example is how this README is structured, it only reads new lines when you skip a line or end the line with 2 spaces at the end. 

## Basic Regular Expressions & Ranges  
Ninja - Looks for Ninja.   
[ng]inja - looks for either a n/g then inja.   
(n|g)inja - Same as above but it can compare words as well as characters.  
[abc123] - looks for any of these values (abc123) in the first character.   
[^123]00 - Won't match 100, 200, 300.   

[a-z] - Matches any letter between a and z inclusive.   
[A-Z] - Same as above but uppercase.   
[0-9] - Matches any 1 digit number  

## Repetition and metacharacters
[abc]{12} - Looks for a, b or c put 12 times.   
[abc]{12, 18} - Between 12 and 18 times inclusive.   
[abc]{5,} - Atleast 5 characters  
[abc]{0,12} - Max 12 times  

/d - Any digit ([0-9]), /D - Any non digit ([^0-9]).   
. - Any character - No limitations. This includes spaces like '     ' but not a line break  
/s - Matches any space, tab or newline character, /S - Matches any non whitespace character.   
/w - Any word character, letters/digits/underscores. , /W is the opposite ([^a-zA-Z0-9_])  
/R - Any unicode new line sequence to break to the next line.   
\b - Word boundary. \bcat\b will match cat as a word but not as part of another, e.g. catalog X.   
\B - Non word boundary - Will match \Bcat\B in catalog.  
\\ - Escape charater, \\. refers to a literal dot and not the metacharacter above.   
\Q..\E - Quote a literal sequence, \Q$.^*()\E will match the string $.^*()  

## Special Characters
? - Makes the character before it optional, it can appear once or not come at all.   
+ - Matches the previous character 1 or more times, [1-9]0+ would match 10 but also 100000.  
* - Previous character matches 0 to many times, a merge of the 2 previous. Minimum of 0, no maximum amount of times.  
^ - Defines start of expression, e.g: ^[0-9]{11}  
$ - Defines end of expression, e.g: [0-9]{11}$  
If we had a telephone number of 079832234582 (12 characters) ^[0-9]{11} would find a match for the first 11 characters, while [0-9]{11}$ would match the last 11 characters. To match only valid 11 digit phone numbers you combine them to make the expression: ^[0-9]{11}$  

## Extra Java Specific RegEX

| Pattern  | Meaning                 | Example                                |  
| -------- | ----------------------- | -------------------------------------- |  
| `\p{L}`  | Any kind of letter      | `\p{L}+` matches words in any language |  
| `\p{N}`  | Any kind of number      | Matches digits in all scripts          |  
| `\p{P}`  | Any punctuation         | `\p{P}` matches `. , ! ?` etc.         |  
| `\p{Zs}` | Any space separator     | More specific than `\s`                |  
| `\P{L}`  | Not a letter (negation) | Like `[^a-zA-Z]` but for all scripts   |  

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
- `?` – Makes the character before it optional; it can appear once or not come at all.
- `+` – Matches the previous character one or more times. Example: `[1-9]0+` would match `10` but also `100000`.
- `*` – Matches the previous character zero or more times. A merge of the two previous quantifiers: minimum of 0, no maximum.
- `^` – Defines the **start** of an expression. Example: `^[0-9]{11}`
- `$` – Defines the **end** of an expression. Example: `[0-9]{11}$`

If we had a telephone number like `079832234582` (12 characters):

- `^[0-9]{11}` would match the **first** 11 digits.
- `[0-9]{11}$` would match the **last** 11 digits.
- To match **only** valid 11-digit phone numbers, use: `^[0-9]{11}$`


## Extra Java Specific RegEX

| Pattern  | Meaning                 | Example                                |  
| -------- | ----------------------- | -------------------------------------- |  
| `\p{L}`  | Any kind of letter      | `\p{L}+` matches words in any language |  
| `\p{N}`  | Any kind of number      | Matches digits in all scripts          |  
| `\p{P}`  | Any punctuation         | `\p{P}` matches `. , ! ?` etc.         |  
| `\p{Zs}` | Any space separator     | More specific than `\s`                |  
| `\P{L}`  | Not a letter (negation) | Like `[^a-zA-Z]` but for all scripts   |  

## JS Related regex functions

| Method                               | Description               | Return Value  |
| ------------------------------------ | ------------------------- | ------------- |
| `string.match(regex)`                | Get matches in string     | Array or null |
| `string.replace(regex, replacement)` | Replace matches           | New string    |
| `string.search(regex)`               | Find index of first match | Index or -1   |
| `string.split(regex)`                | Split string by regex     | Array         |
| `regex.test(string)`                 | Check if regex matches    | Boolean       |
| `regex.exec(string)`                 | Get detailed match info   | Array or null |

## JS Related syntax
 Basic Constructs
Literal characters: /abc/ matches "abc"

Character classes: [abc] matches any one of "a", "b", or "c"

Ranges: [a-z], [0-9]

Negated classes: [^abc] matches any character except "a", "b", or "c"

Dot (.) matches any single character except newline

2. Quantifiers
* — 0 or more times

+ — 1 or more times

? — 0 or 1 time (makes preceding token optional)

{n} — exactly n times

{n,} — at least n times

{n,m} — between n and m times

Example: /a{2,4}/ matches "aa", "aaa", or "aaaa"

3. Anchors
^ — start of string (or line with multiline flag)

$ — end of string (or line with multiline flag)

\b — word boundary

\B — not a word boundary

4. Groups and Capturing
Parentheses ( ... ) to create capture groups

Example: /(\d{3})-(\d{2})/ matches "123-45" and captures "123" and "45"

Non-capturing groups (?: ... ) — group without capturing for backreference

5. Alternation
| acts like OR

Example: /cat|dog/ matches "cat" or "dog"

6. Character Escaping
Escape special characters with \ like \., \*, \+, \?, \\

7. Flags
g — global match (find all matches, not just first)

i — case-insensitive match

m — multiline mode (^ and $ match start/end of lines)

s — dotall mode (dot matches newline too)

u — Unicode mode

y — sticky mode (match at lastIndex only)

8. Lookahead and Lookbehind (ES2018+)
Positive lookahead: foo(?=bar) matches "foo" only if followed by "bar"

Negative lookahead: foo(?!bar) matches "foo" only if NOT followed by "bar"

Positive lookbehind: (?<=foo)bar matches "bar" only if preceded by "foo"

Negative lookbehind: (?<!foo)bar matches "bar" only if NOT preceded by "foo"

9. Backreferences
Refer to captured groups by number: \1, \2, etc.

Example: /(\w)\1/ matches any character followed by itself, like "ee" or "ss"

10. Unicode Property Escapes (ES2018+)
Match Unicode categories: \p{Letter}, \p{Number}, etc. with the u flag

Example: /\p{Emoji}/u matches emoji characters

11. DotAll flag (s)
Normally, dot (.) matches everything except newline characters.

With s flag, dot matches newline too
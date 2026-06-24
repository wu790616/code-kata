---
description: Add a completed coding exercise entry to README and commit
---

# Add Kata

The user has just completed a coding exercise and wants to record it in the root README.md and commit.

## Step 1: Detect context from current directory

Read the current working directory. The path follows the pattern:
`<repo-root>/<language>/<platform>/<exercise>`

Extract:
- **language**: e.g. `ruby`, `clojure`, `go`
- **platform**: e.g. `exercism`, `codewar`, `aoc`
- **exercise slug**: the directory or file name of the exercise

From the exercise slug, derive a candidate **title** using Title Case (e.g. `two-fer` → "Two Fer", `card_tricks` → "Card Tricks", `simple_calculator.rb` → "Simple Calculator").

**Confirm with the user:**
> I detected: **language** = {language}, **platform** = {platform}, **title** = "{title}". Is that correct?

Wait for confirmation or correction before proceeding.

## Step 2: Gather missing info by platform

Read README.md to understand the exact table structure for this language + platform combination, and check what columns exist.

### Exercism
Table columns: `Title | Solution | Concept | Level | Date`
- **Exercise link**: `https://exercism.org/tracks/{language}/exercises/{exercise-slug}`
- **Solution link**: find the main solution file (not test files) under the exercise path in the repo, then construct `https://github.com/wu790616/code-kata/blob/master/{relative-path}`
- **Concept**: ask the user — "What concept(s) does this exercise cover?"
- **Level**: leave empty (match existing rows)
- **Date**: today's date in `YYYY-MM-DD` format

### Codewar
Table columns: `Title | Solution | Level | Date`
- **Kata link**: ask the user — "What is the Codewar kata URL?"
- **Solution link**: find the solution file and construct the GitHub link as above
- **Level**: ask the user — "What is the kyu level? (e.g. 6kyu)"
- **Date**: today's date in `YYYY-MM-DD` format

### AOC
Not a table — skip to Step 3 and check with user what to add.

### Other platforms
Ask the user what info is needed and what format to use, referencing the existing README structure.

## Step 3: Build the row

Match the exact format of existing rows in the README for this language + platform section. Append the new row after the last existing row in that table.

Row format examples to match:
```
|[{title}]({platform-link})|[{Language}]({github-link})|{concept}||{date}|
|[{title}]({kata-link})|[{Language}]({github-link})|{level}|{date}|
```

Use the capitalized language name for the solution link label (e.g. `[Go]`, `[Ruby]`, `[Clojure]`).

## Step 4: Commit

Stage and commit:
- `README.md`
- All new/modified files under the exercise path

Commit message: `Add {language} {exercise-slug}`

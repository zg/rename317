# rename317

An effort to fully rename the 317 client of RuneScape: replacing the
obfuscated class, method and field names of the decompiled client with
descriptive ones, so the code can be read and studied.

## About this repository

- The commit history was imported from the project's original Subversion
  repository, so most commits were made by other contributors. Their authorship
  is preserved in `git log`.
- It is a historical snapshot. Development stopped in 2013 and nothing here is
  maintained.
- It is kept for study and reference, not as a working or supported client.

## Layout

| path | contents |
|---|---|
| `src/` | client source, in the renamed package layout |
| `lib/` | libraries the client depends on |
| `compile.bat`, `run.bat` | Windows build and launch scripts |

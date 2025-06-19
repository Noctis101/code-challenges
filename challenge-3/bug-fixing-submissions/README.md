## Bug Fixing Submissions

Each participant should:

1. Submit the corrected code

2. Comment a short explanation of:
   - What the bug was
   - How they identified it
   - Why their fix is correct

3. Optional: Add a test/assertion or output sample proving it works correctly

Place the corrected code of your choosing in a folder here, naming the folder using the format, first_name-last_name.

## Comment

The bug was:
1.  Line 6: Class.forName("writers." + className); --- The writer class was not in a package called "writers"
2. To accurately get the naming convention of the class, there can be other writers

How Identify:
1. Checking error messages

Why fix is correct:
1. Get rid of the "writers." before the className as its not in a package
2. When the name of the class is wrong it throws NoClassDefFoundError, we can catch that and extract the correct name from the error message and then try to get the correct class name
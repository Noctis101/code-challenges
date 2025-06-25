## Bug Fixing Submissions

Each participant should:

1. Submit the corrected code

2. Comment a short explanation of:
   - What the bug was
      - first error was in line `5` of the WriteFactory.java, this would capitalize the
        type variable that is coming in the method and lower case the remaining characters resulting
        in an invalid class name.
      - second was in line `6` of the WriteFactory.java, this issue was the `writer.` string passed to the
        `Class.forName` method. To fix this, we could either have to remove the `writer.` string from the method which
        is the package name and pass only the class name to the `forName` method. Since the DataWriter interface and
        classes implementing it are in the same package. Option 2 would be to move DataWriter interface and
        classes implementing to a package called `writer.`.
   - How they identified it
      - There was a `ClassNotFoundException` being thrown from the `Class.forName`, which mean that the class we
        are looking for is not being found.
   - Why their fix is correct
      - My fix would move the `DataWriter` and `WriterFactory` class to the writer package and then all the classes
        that implements `DataWriter` would be placed in a sub-package called `impl` this would ensure that all the
        writer file are in one place. Then using `Reflections()` I will take all the classes that implements
        DataWriter, then by appending `writer` to the end of the `type` variable coming in the method and then
        ignoring the case I will check if there is any match and return a new instance of that class. With this
        approach
        no matter how many implementation of DataWriter is created as long as it is in the `writers.impl` and the
        correct prefix of the class name is sent it should return a new instance

3. Optional: Add a test/assertion or output sample proving it works correctly

Place the corrected code of your choosing in a folder here, naming the folder using the format, first_name-last_name.
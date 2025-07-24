package writers.impl;

import writers.DataWriter;

public class ExampleWriter implements DataWriter {
    @Override
    public void write(String data) {
        System.out.println("This is Writing from Example : " + data);
    }
}

package cz.svoboda.primenum;

import cz.svoboda.primenum.app.Application;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Application app = new Application(args);
        app.run();
    }
}

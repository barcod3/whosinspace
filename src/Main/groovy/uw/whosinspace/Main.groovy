package uw.whosinspace

import io.dropwizard.setup.Environment

class Main {

    static void main(String[] args)
    {
        def run = new SpaceApplication<>().run(defaulted(args))

    }

    private static String[] defaulted(String[] args) {
        args ? args : ['server'].toArray()
    }
}

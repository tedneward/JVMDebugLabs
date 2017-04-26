package com.newardassociates.demo;

import java.util.Random;
import java.util.logging.Logger;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    private static Logger LOGGER = Logger.getLogger(App.class.getCanonicalName());

    public static void main(String[] args) {
        LOGGER.entering(App.class.getSimpleName(), "main", args);

        System.out.println("**** BE WARNED: Abandon hope, all ye who enter here....");
        System.out.println("But we'll give you a chance to Ctrl-C (or attach your debugger) before we go on.");
        System.out.println("Press ENTER to continue....");
        try {
            int unused = System.in.read();
        } catch (java.io.IOException ioEx) { /* What could possibly go wrong? */ }

        String whichBug;
        String[] options = {
                "--runaway", "--null", "--eatit", "--deadlock", "--recurse", "--logic", "--classrunaway"
        };
        if (args.length == 0) {
            LOGGER.fine("No option specified; selecting at random");
            whichBug = options[new Random().nextInt(options.length)];
        } else {
            whichBug = args[0];
        }

        LOGGER.fine("Looking to run option " + whichBug);
        switch (whichBug) {
            case "--runaway":
                RunawayAllocation.go(args);
                break;
            case "--null":
                NullInvocation.go(args);
                break;
            case "--eatit":
                EatIt.go(args);
                break;
            case "--deadlock":
                Deadlock.go(args);
                break;
            case "--recurse":
                //InfiniteRecurse.go(args);
                break;
            case "--logic":
                //LogicError.go(args);
                break;
            case "--classrunaway":
                ClassRunaway.go(args);
                break;
            default:
                LOGGER.warning("Unrecognized option: " + whichBug);
                System.out.println("Unrecongized option: " + whichBug);
        }

        LOGGER.exiting("Main", "main");
    }
}

package designPattern.creationalDesignPattern;

/*
 * Singleton design pattern
 *  -> only one instace of class during entire applicaton lifecycle
 *  -> Centralized / global access of single instance
 */
class Logger {
    // private & statice
    private static Logger instance;

    // private Logger
    private Logger() {
    }

    // synchronized used to handle race condition , furthur we will learn in thread
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void getlog(String msg) {
        System.out.println("Log msg " + msg);
    }
}

public class SingleTonDP {
    public static void main(String[] args) {
        // 1st call to get object
        Logger logger = Logger.getInstance();
        logger.getlog("hii");

        // 2nd call to getOjbect
        Logger logger2 = Logger.getInstance();
        logger.getlog("hello");

        /*
         * we for below code (logger == logger2), we will get true
         * because single instance is created whenever getInstance is called
         */
        System.out.println(logger == logger2);
    }
}

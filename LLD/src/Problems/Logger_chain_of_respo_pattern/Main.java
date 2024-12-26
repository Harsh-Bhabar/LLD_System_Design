package Problems.Logger_chain_of_respo_pattern;

public class Main {
    public static void main(String[] args) {
        LogProcessor logger = new InfoLogProcessor(
                                            new ErrorLogProcessor(
                                                    new DebugLogProcessor(
                                                            null
                                                    )
                                            )
                                    );

        logger.log(LogProcessor.INFO, "HELLO");
        logger.log(LogProcessor.DEBUG, "debugging");
        logger.log(LogProcessor.ERROR, "errorrrsss");
    }
}

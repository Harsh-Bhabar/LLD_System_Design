package Problems.Logger_chain_of_respo_pattern;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logLevel, String msg){
        if(logLevel == ERROR){
            System.out.println("ERROR : " + msg);
        }else{
            super.log(logLevel, msg);
        }
    }

}

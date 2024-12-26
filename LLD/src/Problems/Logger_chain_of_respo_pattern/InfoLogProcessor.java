package Problems.Logger_chain_of_respo_pattern;

public class InfoLogProcessor extends LogProcessor {

    InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logLevel, String msg){
        if(logLevel == INFO){
            System.out.println("INFO : " + msg);
        }else{
            super.log(logLevel, msg);
        }
    }

}

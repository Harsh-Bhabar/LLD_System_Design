package Problems.File_System_Composite_Design;

public class File implements FileComponent{
    String fileName;

    File(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display(){
        System.out.println("File name - " + fileName);
    }
}

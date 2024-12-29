package Problems.File_System_Composite_Design;

import java.util.*;

public class Folder implements FileComponent {
    String folderName;
    List<FileComponent> fileComponentList;

    public Folder(String folderName){
        this.folderName = folderName;
        this.fileComponentList = new ArrayList<>();
    }

    public void add(FileComponent fileComponent){
        fileComponentList.add(fileComponent);
    }

    @Override
    public void display(){
        System.out.println("Folder name - " + folderName);
        for(FileComponent fileComponent: fileComponentList){
            fileComponent.display();
        }
    }
}

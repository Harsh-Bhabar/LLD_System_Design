package Problems.File_System_Composite_Design;

public class Main {
    public static void main(String[] args) {
        // movies folder
        Folder allMovies = new Folder("Movies");

        // folders in allMovies
        Folder pixarMovies = new Folder("Pixar");
        Folder marvelMovies = new Folder("Marvel");

        marvelMovies.add(new File("Avengers"));

        pixarMovies.add(new File("Cars"));
        pixarMovies.add(new File("Finding Nemo"));

        // folders to root folders
        allMovies.add(pixarMovies);
        allMovies.add(marvelMovies);


        allMovies.display();
    }
}

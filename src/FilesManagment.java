import java.util.Vector;

/**
 * Facade class that centralizes all file operations
 * such as creating, deleting, reading, and writing files.
 * Meaning it is just the front used for these operations.
 */
public class FilesManagment {
    private FileCreator creador;
    private FileDeleter borrador;
    private FileWritter escritor;
    private FileReader lector;
    public FilesManagment(){
        this.creador = new FileCreator();
        this.borrador = new FileDeleter();
        this.escritor = new FileWritter();
        this.lector = new FileReader();
    }
    /**
     * Creates a file at the specified path.
     * @param name Path and name of the file
     */
    public void CreateFile(String name) { //Includes target path
        this.creador.CreateFile(name);
    }
    /**
     * Deletes a file at the specified path.
     * @param target Path of the file to delete
     */
    public void DeleteFile(String target) {
        this.borrador.DeleteFile(target);
    }
    /**
     * Writes text content to a file.
     * @param target Path of the file
     * @param text   Content to write
     */
    public void WriteToTarget(String target, Vector<String> text){
        this.escritor.WriteToTarget(target,text);
    }
    /**
     * Reads the content of a file.
     * @param target Path of the file
     * @return Lines read from the file
     */
    public Vector<String> ReadFile(String target) { return this.lector.ReadFile(target); }
}

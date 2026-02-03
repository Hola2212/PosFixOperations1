import java.util.Vector;

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
    public void CreateFile(String name) { //Includes target path
        this.creador.CreateFile(name);
    }
    public void DeleteFile(String target) {
        this.borrador.DeleteFile(target);
    }
    public void WriteToTarget(String target, String[] text){
        this.escritor.WriteToTarget(target,text);
    }
    public Vector<String> ReadFile(String target) { return this.lector.ReadFile(target); }
}

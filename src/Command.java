import java.io.Serializable;

// A interface precisa ser Serializable para simular o armazenamento em disco
public interface Command extends Serializable {
    void execute(); // Executa o comando
    
    // Novo método para a funcionalidade de backup
    void store(); 
    
    // Novo método para a funcionalidade de restauração
    void load();
}
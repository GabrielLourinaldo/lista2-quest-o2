import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Simula o registro de comandos em "disco" para fins de recuperação
public class CommandLog implements Serializable {
    private List<Command> history = new ArrayList<>();
    
    public void addCommand(Command command) {
        // Em uma aplicação real, aqui haveria serialização para um arquivo.
        history.add(command);
        command.store(); // Chama o store() no momento da execução/registro
        System.out.println("  [LOG] Command logged successfully: " + command.getClass().getSimpleName());
    }

    public List<Command> getHistory() {
        return history;
    }

    // Simulação de Recarga (Load) após uma falha
    public void recover() {
        System.out.println("\n*** SIMULANDO RECUPERAÇÃO APÓS FALHA ELÉTRICA ***");
        
        // Em uma aplicação real, aqui haveria deserialização do arquivo.
        
        System.out.println("Recarregando e re-executando " + history.size() + " comandos registrados:");
        for (Command command : history) {
            command.load(); // Invoca o load() em cada comando
        }
        System.out.println("*** RECUPERAÇÃO CONCLUÍDA ***\n");
    }
}
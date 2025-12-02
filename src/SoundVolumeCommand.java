import java.io.Serializable;

public class SoundVolumeCommand implements Command, Serializable {
    private Sound sound;
    private int newVolume;
    private int previousVolume; // Estado a ser salvo

    // O construtor recebe o Receiver (Sound) e o parâmetro da ação (newVolume)
    public SoundVolumeCommand(Sound sound, int newVolume) {
        this.sound = sound;
        this.newVolume = newVolume;
    }

    @Override
    public void execute() {
        // Antes de executar, armazena o estado atual (para o "undo" ou "store")
        this.store(); 
        
        sound.setVolume(newVolume);
    }

    // O método store() captura o estado do Receiver *antes* da execução
    @Override
    public void store() {
        this.previousVolume = sound.getVolume();
        // Em um sistema real, você registraria este objeto Command em um arquivo/DB
        System.out.println("  [LOG] Stored previous volume: " + previousVolume);
    }
    
    // O método load() simula a restauração do estado anterior
    // Ele é usado para o backup pós-falha, onde re-executamos a ação
    @Override
    public void load() {
        // Para a restauração pós-falha, simplesmente re-executamos o comando original:
        this.execute();
        System.out.println("  [RECOVERY] Command loaded and re-executed: Set Sound Volume to " + newVolume);
    }
}
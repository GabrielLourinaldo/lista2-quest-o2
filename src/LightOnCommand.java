import java.io.Serializable;

public class LightOnCommand implements Command, Serializable {
    private Light light;
    
    // O construtor recebe o Receiver (Light)
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void store() {
        // Para uma ação simples ON/OFF, o store registra a intenção
        // (Em casos mais complexos, salvaria o estado anterior, mas aqui é minimalista)
        System.out.println("  [LOG] Stored action: Light ON");
    }

    @Override
    public void load() {
        // Para restaurar, simplesmente re-executamos a ação
        this.execute();
        System.out.println("  [RECOVERY] Command loaded and re-executed: Light ON");
    }
}
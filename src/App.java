public class App {
    public static void main(String[] args) {
        
        // 1. Configurar Dispositivos (Receivers)
        Light livingRoomLight = new Light("Living Room");
        Sound livingRoomSound = new Sound("Living Room");
        
        // 2. Configurar o Log de Comandos
        CommandLog commandLog = new CommandLog();
        
        // --- INÍCIO DA EXECUÇÃO NORMAL (Registrando Comandos) ---
        System.out.println("--- 1. EXECUTANDO COMANDOS E REGISTRANDO NO LOG ---");
        
        // Comando 1: Ligar a Luz
        Command lightOn = new LightOnCommand(livingRoomLight);
        lightOn.execute();
        commandLog.addCommand(lightOn); // Adiciona ao log para registro/store()
        
        // Comando 2: Ajustar Volume (Comando de Estado)
        Command setVolume10 = new SoundVolumeCommand(livingRoomSound, 10);
        setVolume10.execute(); // O store() é chamado aqui dentro (captura o estado 5)
        commandLog.addCommand(setVolume10); 
        
        // Comando 3: Ajustar Volume novamente
        Command setVolume15 = new SoundVolumeCommand(livingRoomSound, 15);
        setVolume15.execute(); // O store() é chamado aqui dentro (captura o estado 10)
        commandLog.addCommand(setVolume15); 
        
        System.out.println("\nESTADO FINAL ANTES DA FALHA:");
        System.out.println(livingRoomLight); // Deve estar ON
        System.out.println(livingRoomSound); // Volume deve ser 15
        
        // --- 2. SIMULAÇÃO DE FALHA ELÉTRICA ---
        System.out.println("\n***********************************");
        System.out.println("*** SIMULANDO: PANE ELÉTRICA (FALHA) ***");
        System.out.println("***********************************");

        // Simular que os dispositivos "esqueceram" seus estados (reset)
        // Em um cenário real, você reiniciaria as instâncias ou resetaria o estado delas.
        // Aqui, apenas demonstramos o processo de recuperação do log.
        
        // --- 3. PROCESSO DE RESTAURAÇÃO (LOAD) ---
        commandLog.recover(); // Chama o método recover que itera e chama load()
        
        // --- 4. VERIFICAÇÃO PÓS-RECUPERAÇÃO ---
        System.out.println("\nESTADO PÓS-RECUPERAÇÃO:");
        System.out.println(livingRoomLight); // Deve ter sido restaurado para ON
        System.out.println(livingRoomSound); // Volume deve ter sido restaurado para 15
        
        // Nota: LightOnCommand e SoundVolumeCommand precisam ser implementados
        // seguindo a lógica do CommandLog para funcionar corretamente.
    }
}
public class Sound {
    private String location;
    private int volume;

    public Sound(String location) {
        this.location = location;
        this.volume = 5; // Default volume
    }

    public void on() {
        System.out.println(location + " Sound System is ON");
    }
    public void off() {
        System.out.println(location + " Sound System is OFF");
    }
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " Sound volume set to " + volume);
    }
    // Simplificando os outros métodos para ilustração:
    public void setCd() { /* ... */ } 
    public void setDvd() { /* ... */ } 
    public void setRadio() { /* ... */ } 

    // Métodos para backup/restauração (Estado do Receiver)
    public int getVolume() { 
        return volume; 
    }
    // ... outros getters para o estado

    @Override
    public String toString() {
        return "Sound [location=" + location + ", volume=" + volume + "]";
    }
}
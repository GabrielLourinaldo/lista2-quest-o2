public class Light {
    private String location; // Para saber qual luz
    
    public Light(String location) {
        this.location = location;
    }
    
    public void on() {
        System.out.println(location + " Light is ON");
    }
    
    public void off() {
        System.out.println(location + " Light is OFF");
    }

    @Override
    public String toString() {
        return "Light [location=" + location + "]";
    }
}
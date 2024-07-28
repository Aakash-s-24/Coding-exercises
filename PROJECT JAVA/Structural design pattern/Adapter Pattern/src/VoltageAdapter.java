public class VoltageAdapter implements Appliance {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        if (voltage220V == null) {
            throw new IllegalArgumentException("Voltage220V cannot be null");
        }
        this.voltage220V = voltage220V;
    }

    @Override
    public void plugIn() {
        System.out.println("Using VoltageAdapter to convert 220V to 110V.");
        voltage220V.supply220V();
        // Simulate conversion
        System.out.println("Converted 220V to 110V.");
        System.out.println("110V Appliance is now plugged in and working.");
    }
}

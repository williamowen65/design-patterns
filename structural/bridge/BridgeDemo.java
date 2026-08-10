public class BridgeDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl basicRemote = new RemoteControl(tv);

        basicRemote.togglePower();
        basicRemote.volumeUp();

        System.out.println();

        Device radio = new Radio();
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);

        advancedRemote.togglePower();
        advancedRemote.volumeUp();
        advancedRemote.mute();
    }
}

package nguyenduck.manifest.modules.module;

public class DataModule extends Module {

    public DataModule(String uuid) {
        super("data");
        this.uuid.setValue(uuid);
    }

    public DataModule(String uuid, Integer[] version) {
        this(uuid);
        this.version.setValue(version);
    }
}

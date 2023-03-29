package nguyenduck.manifest.modules.module;

public class ResourcesModule extends Module {

    public ResourcesModule(String uuid) {
        super("resources");
        this.uuid.setValue(uuid);
    }

    public ResourcesModule(String uuid, Integer[] version) {
        this(uuid);
        this.version.setValue(version);
    }
}

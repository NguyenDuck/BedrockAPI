package nguyenduck.manifest.modules.module;

import nguyenduck.manifest.header.Description;
import nguyenduck.utils.CJsonObject;
import nguyenduck.utils.Optional;
import nguyenduck.utils.Required;

public class Module extends CJsonObject {

    @Required
    public Type type = new Type();
    @Optional
    public Description description = new Description();
    @Required
    public UUID uuid = new UUID();
    @Required
    public Version version = new Version();

    public Module() {
        super();
    }

    public Module(String type) {
        this();
        this.type = new Type(type);
    }
}

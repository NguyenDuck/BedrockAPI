package nguyenduck.manifest.header;

import nguyenduck.manifest.modules.module.UUID;
import nguyenduck.manifest.modules.module.Version;
import nguyenduck.utils.Optional;
import nguyenduck.utils.Property;
import nguyenduck.utils.Required;

public class Header extends Property {

    @Required
    public Name name = new Name();
    @Optional
    public Description description = new Description();
    @Required
    public MinEngineVersion min_engine_version = new MinEngineVersion();
    @Required
    public UUID uuid = new UUID();
    @Required
    public Version version = new Version();

    public Header() {
        super("header");
    }
}

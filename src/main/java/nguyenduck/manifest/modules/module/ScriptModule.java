package nguyenduck.manifest.modules.module;

import nguyenduck.manifest.modules.module.script.Entry;
import nguyenduck.manifest.modules.module.script.Language;
import nguyenduck.utils.Required;

public class ScriptModule extends Module {

    @Required(1)
    public Language language = new Language();
    @Required(1)
    public Entry entry = new Entry();

    public ScriptModule(String uuid) {
        super("script");
        this.uuid.setValue(uuid);
    }

    public ScriptModule(String uuid, Integer[] version) {
        this(uuid);
        this.version.setValue(version);
    }
}

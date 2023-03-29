package nguyenduck.manifest.modules;

import nguyenduck.manifest.modules.module.DataModule;
import nguyenduck.manifest.modules.module.ScriptModule;

public class BehaviorModules extends Modules {

    public void addDataModule(String uuid) {
        add(new DataModule(uuid));
    }

    public void addDataModule(String uuid, Integer[] version) {
        add(new DataModule(uuid, version));
    }

    public void addScriptModule(String uuid) {
        add(new ScriptModule(uuid));
    }

    public void addScriptModule(String uuid, Integer[] version) {
        add(new ScriptModule(uuid, version));
    }
}

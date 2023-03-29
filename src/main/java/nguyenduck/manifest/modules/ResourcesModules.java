package nguyenduck.manifest.modules;

import nguyenduck.manifest.modules.module.ResourcesModule;

public class ResourcesModules extends Modules {

    public void addResourcesModule(String uuid) {
        add(new ResourcesModule(uuid));
    }

    public void addResourcesModule(String uuid, Integer[] version) {
        add(new ResourcesModule(uuid, version));
    }

}

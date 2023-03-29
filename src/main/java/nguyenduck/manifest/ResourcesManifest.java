package nguyenduck.manifest;

import nguyenduck.manifest.modules.ResourcesModules;
import nguyenduck.utils.Required;

public class ResourcesManifest extends Manifest {

    @Required(1)
    public ResourcesModules modules = new ResourcesModules();
}

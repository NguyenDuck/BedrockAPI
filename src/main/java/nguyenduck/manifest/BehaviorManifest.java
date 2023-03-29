package nguyenduck.manifest;

import nguyenduck.manifest.modules.BehaviorModules;
import nguyenduck.utils.Required;

public class BehaviorManifest extends Manifest {

    @Required(1)
    public BehaviorModules modules = new BehaviorModules();

}

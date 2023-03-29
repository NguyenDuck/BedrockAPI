package nguyenduck.manifest.modules.module;

import nguyenduck.utils.Property;

public class Version extends Property {

    public Version() {
        super("version");
        setValue(new Integer[]{1, 0, 0});
    }



}

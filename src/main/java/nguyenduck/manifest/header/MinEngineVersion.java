package nguyenduck.manifest.header;

import nguyenduck.utils.Property;

public class MinEngineVersion extends Property {

    public MinEngineVersion() {
        super("min_engine_version");
        setValue(new Integer[]{1, 19, 70});
    }
}

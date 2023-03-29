package nguyenduck.manifest.modules.module.script;

import nguyenduck.utils.Property;

public class Entry extends Property {

    public Entry() {
        super("entry");
        setValue("scripts/main.js");
    }

    /**
     * @param path Default path is "scripts/{your_path}.js"
     */
    public Entry(String path) {
        this();
        setValue("scripts/" + path + ".js");
    }

}

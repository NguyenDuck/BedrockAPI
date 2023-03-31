package nguyenduck.manifest.modules;

import nguyenduck.manifest.modules.module.Module;
import nguyenduck.utils.Property;
import nguyenduck.utils.Required;

public class Modules extends Property {

    @Required
    public Module[] value;

    public Modules() {
        super("modules");
    }

    public void add(Module module) {
        Module[] arr = new Module[getValue().length + 1];
        System.arraycopy(getValue(), 0, arr, 0, getValue().length);
        arr[arr.length - 1] = module;
        setValue(arr);
    }

    @Override
    public void setValue(Object value) {
        this.value = (Module[]) value;
    }

    @Override
    public Module[] getValue() {
        if (value == null) value = new Module[0];
        return this.value;
    }
}

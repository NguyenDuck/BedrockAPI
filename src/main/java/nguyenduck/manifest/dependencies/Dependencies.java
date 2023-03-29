package nguyenduck.manifest.dependencies;

import com.google.gson.JsonArray;
import nguyenduck.manifest.dependencies.dependency.Dependency;
import nguyenduck.utils.Property;
import nguyenduck.utils.Required;

public class Dependencies extends Property {

    @Required
    public Dependency[] value;

    Dependencies() {
        super("dependencies");
    }

    public void add(Property module) {
        if (getValue() == null) setValue(new JsonArray());
        getValue().add(module.asJsonElement());
    }

    @Override
    public JsonArray getValue() {
        return (JsonArray) super.getValue();
    }
}

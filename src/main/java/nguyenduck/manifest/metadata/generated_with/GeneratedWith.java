package nguyenduck.manifest.metadata.generated_with;

import com.google.gson.JsonObject;
import nguyenduck.utils.CustomProperty;
import nguyenduck.utils.Property;

public class GeneratedWith extends Property {

    private CustomProperty properties = new CustomProperty();

    public GeneratedWith() {
        super("generated_with");
        setValue(new JsonObject());
    }

    public void add(String name, String[] value) {
        properties.addProperty(name, value);
    }

    @Override
    public void compile() throws IllegalAccessException {
        properties.compile();
        setValue(properties.getValue());
        super.compile();
    }
}

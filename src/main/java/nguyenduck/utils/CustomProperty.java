package nguyenduck.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class CustomProperty extends Property {

    private final ArrayList<String> nameList = new ArrayList<>();
    private final ArrayList<String[]> valueList = new ArrayList<>();

    public CustomProperty() {
        super(null);
        setValue(new JsonObject());
    }

    @Override
    public JsonObject getValue() {
        return (JsonObject) super.getValue();
    }

    public void addProperty(String name, String[] value) {
        nameList.add(name);
        valueList.add(value);
    }

    @Override
    public void compile() throws IllegalAccessException {
        JsonObject value = getValue();
        JsonArray entry;
        for (int i = 0; i < nameList.size(); i++) {
            entry = new JsonArray();
            String[] j2 = valueList.get(i);
            for (String s : j2) entry.add(s);
            value.add(nameList.get(i), entry);
        }
        setValue(value);
        super.compile();
    }
}

package nguyenduck.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import nguyenduck.GlobalIndent;
import nguyenduck.exceptions.MissingPropertyException;

import java.lang.reflect.Field;

public abstract class Property implements Compilable, Jsonable {

    private final String propName;
    private Object value;

    public Property(String propName) {
        this.propName = propName;
    }

    public String getName() {
        return propName;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public Object getValue() {
        return value;
    }
    public Boolean validate() {
        return getValue() != null;
    }

    @Override
    public void compile() throws IllegalAccessException {
        GlobalIndent.add();

        for (Field field : this.getClass().getFields()) {
            System.out.println(GlobalIndent.get() + field.getName());

            Object fieldinstance = field.get(this);

            if (fieldinstance instanceof Compilable) {
                Compilable compiler = (Compilable) field.get(this);
                if (compiler == null) continue;
                compiler.compile();

                Property property = (Property) compiler;
                if (!(value instanceof JsonObject)) value = new JsonObject();
                ((JsonObject) value).add((property.getName()), property.asJsonElement());
                Required annotation = field.getAnnotation(Required.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    if (!property.validate()) throw new MissingPropertyException(field);
                }
            } else if (fieldinstance instanceof Compilable[]) {
                Compilable[] compilers = (Compilable[]) field.get(this);
                if (compilers == null) continue;
                for (Compilable compiler : compilers) compiler.compile();
            }
        }
        GlobalIndent.del();
    }

    public JsonElement asJsonElement() {
        if (getValue() instanceof Number) return new JsonPrimitive((Number) getValue());
        else if (getValue() instanceof String) return new JsonPrimitive((String) getValue());
        else if (getValue() instanceof Boolean) return new JsonPrimitive((Boolean) getValue());
        else if (getValue() instanceof JsonElement) return (JsonElement) getValue();
        else if (getValue() instanceof Number[]) {
            JsonArray o = new JsonArray(((Number[]) getValue()).length);
            for (Number n : (Number[]) getValue()) o.add(n);
            return o;
        } else if (getValue() instanceof String[]) {
            JsonArray o = new JsonArray(((String[]) getValue()).length);
            for (String n : (String[]) getValue()) o.add(n);
            return o;
        } else if (getValue() instanceof Boolean[]) {
            JsonArray o = new JsonArray(((Boolean[]) getValue()).length);
            for (Boolean n : (Boolean[]) getValue()) o.add(n);
            return o;
        } else if (getValue() instanceof CJsonObject[]) {
            JsonArray o = new JsonArray();
            for (CJsonObject p : (CJsonObject[]) getValue()) o.add(p.asJsonElement());
            return o;
        } else {
            return null;
        }
    }
}

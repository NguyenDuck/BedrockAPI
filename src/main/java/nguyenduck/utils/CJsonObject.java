package nguyenduck.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import nguyenduck.GlobalIndent;
import nguyenduck.exceptions.MissingPropertyException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CJsonObject implements Compilable, Jsonable {

    private final JsonObject value = new JsonObject();

    @Override
    public void compile() throws IllegalAccessException {
        System.out.println(GlobalIndent.get() + "Compiling " + getClass());
        GlobalIndent.add();

        PropertyQueue queue = new PropertyQueue();

        for (Field field : this.getClass().getFields()) {
            if (field.getType().getSuperclass() == Property.class) {
                Property property = (Property) field.get(this);
                property.compile();
                Required annotation = field.getAnnotation(Required.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    if (!property.validate()) throw new MissingPropertyException(field);
                }
                queue.add(getPriority(field), property);
            }
        }

        queue.forEach((p) -> value.add(p.getName(), p.asJsonElement()));

        GlobalIndent.del();
    }

    public JsonElement asJsonElement() {
        try {
            compile();
            return value;
        } catch (IllegalAccessException ignored) {}
        return new JsonObject();
    }

    private Integer getPriority(Field field) {
        int priority = 0;
        for (Annotation annotation : field.getAnnotations()) {
            if (annotation instanceof Required) {
                field.setAccessible(true);
                priority = field.getAnnotation(Required.class).value();
            } else if (annotation instanceof Optional) {
                field.setAccessible(true);
                priority = field.getAnnotation(Optional.class).value();
            }
        }
        return priority;
    }
}

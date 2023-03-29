package nguyenduck.file;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import nguyenduck.GlobalIndent;
import nguyenduck.utils.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class JsonFileContent extends FileContent implements Compilable {

    private final JsonObject jsonContent = new JsonObject();

    public JsonFileContent(String fileName) {
        super(fileName, "json");
    }

    public void compile() throws IllegalAccessException {
        System.out.println("Json Compiling " + this.getClass());
        GlobalIndent.add();

        PropertyQueue queue = new PropertyQueue();

        for (Field field : this.getClass().getFields()) {
            if (field.get(this) instanceof Property) {
                System.out.println(GlobalIndent.get() + "Compiling Property: " + field.getType() + " " + field.getName());
                Property property = (Property) field.get(this);
                property.compile();
                queue.add(getPriority(field), property);
            }
        }

        queue.forEach((p) -> jsonContent.add((p.getName()), p.asJsonElement()));
        setContent(new GsonBuilder().setPrettyPrinting().create().toJson(jsonContent));
        GlobalIndent.del();
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

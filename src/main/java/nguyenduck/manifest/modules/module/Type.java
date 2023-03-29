package nguyenduck.manifest.modules.module;

import nguyenduck.utils.Property;

public class Type extends Property {

    public Type() {
        super("type");
    }

    public Type(String type) {
        this();
        setValue(ModuleTypeEnum.get(type));
    }

    enum ModuleTypeEnum {
        DATA("data"),
        SCRIPT("script"),
        RESOURCES("resources"),
        ;

        public final String value;

        ModuleTypeEnum(String typeAsString) {
            value = typeAsString;
        }

        public static String get(String type) {
            for (ModuleTypeEnum t : ModuleTypeEnum.values()) {
                if (t.value.equals(type)) return type;
            }
            return null;
        }
    }
}

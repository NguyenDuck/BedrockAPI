package nguyenduck.manifest.metadata;

import nguyenduck.manifest.metadata.authors.Authors;
import nguyenduck.manifest.metadata.generated_with.GeneratedWith;
import nguyenduck.utils.Optional;
import nguyenduck.utils.Property;

public class Metadata extends Property {

    @Optional
    public final Authors authors = new Authors();
    @Optional
    public final GeneratedWith generated_with = new GeneratedWith();

    public Metadata() {
        super("metadata");
        generated_with.add("BedrockAPI", new String[]{"1.0.0"});
    }

}

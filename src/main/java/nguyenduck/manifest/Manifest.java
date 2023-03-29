package nguyenduck.manifest;

import nguyenduck.file.JsonFileContent;
import nguyenduck.manifest.header.Header;
import nguyenduck.manifest.metadata.Metadata;
import nguyenduck.utils.Optional;
import nguyenduck.utils.Required;

public class Manifest extends JsonFileContent {

    @Required
    public final FormatVersion format_version = new FormatVersion();
    @Optional
    public final Metadata metadata = new Metadata();
    @Required
    public final Header header = new Header();

    public Manifest() {
        super("manifest");

    }
}

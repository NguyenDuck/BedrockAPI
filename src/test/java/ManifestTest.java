import nguyenduck.manifest.BehaviorManifest;
import org.junit.jupiter.api.Test;

public class ManifestTest {

    @Test
    public void tempFile() throws IllegalAccessException {
        BehaviorManifest bevManifest = new BehaviorManifest();
        bevManifest.header.name.setValue("Ex Nihilo: Bedrock");
        bevManifest.header.description.setValue("Out Of Nothing");
        bevManifest.header.uuid.setValue("51cd6491-c9b6-464e-8f1c-d54176553af7");
        bevManifest.modules.addDataModule("ef164cbb-c843-45a2-b882-3640ce632dfc");
        bevManifest.modules.addScriptModule("0999677b-0512-4e22-bbdc-94be7d67b637");
        bevManifest.metadata.authors.addAuthor("NguyenDuck");
        bevManifest.compile();
        String content = bevManifest.getContent();
        System.out.println(content);
    }

}

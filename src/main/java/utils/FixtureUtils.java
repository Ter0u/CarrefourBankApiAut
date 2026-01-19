package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class FixtureUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> loadAsMap(String path) {
        try {
            InputStream is = FixtureUtils.class
                    .getClassLoader()
                    .getResourceAsStream(path);

            if (is == null) {
                throw new RuntimeException("Arquivo não encontrado em resources: " + path);
            }

            return mapper.readValue(
                    is,
                    new TypeReference<HashMap<String, Object>>() {}
            );

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar fixture: " + path, e);
        }
    }
}

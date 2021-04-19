package edu.bsu.cs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// map, filter, reduce, distinct, concat

/**
 * Contains learning tests to demonstrate knowledge of higher-order functions
 * as used within
 * <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/stream/package-summary.html">
 *     Java's Stream API</a>.
 */
public class HigherOrderFunctionsLearningTest {

    // This method demonstrates a well-formed solution.
    @Test
    public void testCollect() {
        List<Integer> actual =
                Stream.of(1, 2, 3)
                        .collect(Collectors.toList());
        List<Integer> expected = List.of(1, 2, 3);
        Assertions.assertIterableEquals(expected, actual);
    }

    // Use the 'map' function to do the transformation.
    @Test
    public void testMap() {
        List<Integer> actual = null; // Use input: {1, 2, 3}
        List<Integer> expected = List.of(2, 3, 4);
        Assertions.assertIterableEquals(expected, actual);
    }

    /**
     * A learning test that validates reading JSON results correctly.
     */
    @Test
    public void testReadRevisions() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("soup.json");
        JSONArray jsonArray = JsonPath.read(in, "$..revisions.*");
        ObjectMapper mapper = new ObjectMapper();
        Revision[] revisions = mapper.readValue(jsonArray.toString(), Revision[].class);
        Assertions.assertEquals(50, revisions.length);
    }
}

@JsonAutoDetect
class Revision {
    public String user;
    public String timestamp;
}
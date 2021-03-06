package csvsorter;

import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class MainTestsIntegrationTests {

    @Test
    public void testMain_10Records_2max() throws IOException {
        String inputCSVFile = "src\\test\\resources\\inputTest.csv";
        String outputFile = "src\\test\\resources\\sorted.csv";
        String[] args = {"-in", inputCSVFile, "-key", "0", "-max", "2", "-out", outputFile};
        Main.main(args);

        List<String> outputFileOfcsvsorter = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
        assert Ordering.natural().isOrdered(outputFileOfcsvsorter);
    }

    @Test
    public void testMain_10Records_3max() throws IOException {
        String inputCSVFile = "src\\test\\resources\\inputTest.csv";
        String outputFile = "src\\test\\resources\\sorted.csv";
        String[] args = {"-in", inputCSVFile, "-key", "0", "-max", "3", "-out", outputFile};
        Main.main(args);

        List<String> outputFileOfcsvsorter = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
        assert Ordering.natural().isOrdered(outputFileOfcsvsorter);
    }
}

import java.io.IOException;
import java.util.List;
import java.util.Map;

import src.CSVManager;
import src.GetStatistics;

public class Main {
    public static void main(String[] args) throws IOException {
        String dirPath = args[0];
        String fileName = args[1];

        CSVManager csvManager = new CSVManager(dirPath, fileName);
        csvManager.getCSVData();
        List<Map<String, String>> playStoreData = csvManager.getCSVData();
        GetStatistics getStatistics = new GetStatistics(playStoreData);

        Map<String, List<Float>> categoryRatings = getStatistics.extractCategoryRatings();
        getStatistics.getMaxRatings(categoryRatings);
        getStatistics.getMinRatings(categoryRatings);
        getStatistics.getAverageRatings(categoryRatings);
    }
}


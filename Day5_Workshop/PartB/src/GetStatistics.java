package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStatistics {
    private final List<Map<String, String>> playStoreData;

    public GetStatistics(List<Map<String, String>> playStoreData) {
        this.playStoreData = playStoreData;
    }

    public Map<String, List<Float>> extractCategoryRatings() {
        Map<String, List<Float>> categoryRatings = new HashMap<>();
        for (Map<String, String> app:playStoreData) {
            // Generate a new list of ratings for each unique category
            String category = app.get("Category");
            if (categoryRatings.get(category) == null) {
                List<Float> ratings = new ArrayList<>();
                categoryRatings.put(category, ratings);
            } 

            if (app.get("Rating").equals("NaN")) {
                categoryRatings.get(category).add(0.0f);
            } else {
                categoryRatings.get(category).add(Float.valueOf(app.get("Rating")));
            }
        }
        return categoryRatings;
    }

    public void getMaxRatings(Map<String, List<Float>> categoryRatings) {
        for (String category : categoryRatings.keySet()) {
            System.out.printf("Max Rating for %s : %.2f \n", category, Collections.max(categoryRatings.get(category)));
        }
    }

    public void getMinRatings(Map<String, List<Float>> categoryRatings) {
        for (String category : categoryRatings.keySet()) {
            System.out.printf("Min Rating for %s : %.2f \n", category, Collections.min(categoryRatings.get(category)));
        }
    }

    public void getAverageRatings(Map<String, List<Float>> categoryRatings) {
        for (String category : categoryRatings.keySet()) {
            List<Float> ratingList = categoryRatings.get(category);
            Float average = sumOfRatings(ratingList)/ratingList.size();
            System.out.printf("Average Rating for %s : %.2f \n", category, average);
        }
    }

    private Float sumOfRatings(List<Float> ratings) {
        Float sum = 0.00f;
        for (Float rating : ratings) {
            sum += rating;
        }
        return sum;
    }

    
}

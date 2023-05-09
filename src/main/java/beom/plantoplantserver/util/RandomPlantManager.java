package beom.plantoplantserver.util;

import beom.plantoplantserver.model.entity.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomPlantManager {

    List<Plant> plantList;
    int[] percentage;
    int PERCENTAGE_MAX = 1000;

    public RandomPlantManager(List<Plant> plants) {
        plantList = plants;
        percentage = new int[PERCENTAGE_MAX];
    }

    public Plant getRandomPlant() {
        setPercentage();

        int randomResult = percentage[getRandomInteger(PERCENTAGE_MAX)];
        Plant result = null;
        
        for (Plant p : plantList) {
            if (p.getId() == randomResult) {
                result = p;
                break;
            }
        }
        
        return result;
    }
    public HashMap<Plant, Integer> getRandomPlants(int count) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Plant, Integer> resultPlants = new HashMap<>();
        setPercentage();

        for (int i = 0; i < count; i++) {
           arr.add(percentage[getRandomInteger(PERCENTAGE_MAX)]);
        }

        // arr 에 있는 것들 hashmap에 정리해서 저장

        return resultPlants;
    }

    private void setPercentage() {
        int sum = 0;

        for (Plant p : plantList) {
            int plantId = p.getId();
            int plant_percentage = (int) (p.getPercentage() * 1000);

            for (int i = 0; i < plant_percentage; i++) {
                percentage[sum] = plantId;
                // System.out.println(sum + "번째: " + percentage[sum] + " ");
                sum++;
            }
        }
    }

    private int getRandomInteger(int range) {
        return (int) (Math.random() * range);
    }
}

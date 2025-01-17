package Problems.Food_Delivery_System.Core_Functionalities;

import Problems.Food_Delivery_System.Core_Classes.*;

import java.util.*;

public class RestaurantService {
    private HashMap<Integer, Restaurant> restaurants = new HashMap<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getRestaurantId(), restaurant);
    }

    public List<Restaurant> listRestaurants() {
        return List.copyOf(restaurants.values());
    }
}

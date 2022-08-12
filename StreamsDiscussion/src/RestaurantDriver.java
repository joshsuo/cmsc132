import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantDriver {
	public static void main(String[] args) {
//		A customer asks:
//		What are the calorie counts for three of your lowest-calorie breakfast options, excluding salads?

		ArrayList<MenuItem> menu = new ArrayList<>(Arrays.asList(MenuItem.values()));

		List<Integer> calorieCountsForThreeLowestCalorieItems = menu.stream()
				.filter(menuItem -> !menuItem.name.contains("Salad"))
				.map(MenuItem::getCalorieCount)
				.sorted().distinct().limit(3)
				.collect(Collectors.toList());

		System.out.println(calorieCountsForThreeLowestCalorieItems);
	}
}

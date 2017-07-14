package restList;

import java.util.List;

public interface RestaurantDAO_Interface {
	public void add(Restaurant rest);
	public void update(Restaurant rest);
	public void delete(Integer restNo);
	public Restaurant findByPK(Integer restNo);
	public List<Restaurant> getAll();
}

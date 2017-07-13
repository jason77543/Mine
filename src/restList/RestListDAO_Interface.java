package restList;

import java.util.List;

public interface RestListDAO_Interface {
	public void add(RestList restList);
	public void update(RestList restList);
	public void delete(Integer restListNo);
	public RestList findByPK(Integer restListNo);
	public List<RestList> getAll();
}

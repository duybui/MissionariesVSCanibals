
public class State {

	public int C_left, M_left;
	public String boat_side;
	public State parent_state;
	public boolean isVisited = false; // this is for the dfs
	
	public State(int cannibals_on_left, int missionaries_on_left, String side)//, State parent)
	{
		C_left = cannibals_on_left;
		M_left = missionaries_on_left;
		boat_side = side;
		//parent_state = parent;
	}
	
	public String print()
	{
		return "state(C=" + C_left +",M="+ M_left + ",boat=" + boat_side +")";
	}
	
	public boolean isValid()
	{
		if (M_left ==3 || M_left ==0)
			return true;
		else if (M_left >= C_left && (3-M_left) >= 3-C_left)
			return true;
		else 
			return false;
	}
	public int get_C_on_left()
	{
		return C_left;
	}
	public int get_M_on_left()
	{
		return M_left;
	}
	public String get_side()
	{
		return boat_side;
	}

	public boolean isEqual(State another_state) {
		if (this.get_C_on_left()== another_state.get_C_on_left() && this.get_M_on_left() == another_state.get_M_on_left() && this.get_side()==another_state.get_side())
			return true;
		else
			return false;
	}
//	public State get_parent()
//	{
//		return parent_state;
//	}
	
	
	
}
